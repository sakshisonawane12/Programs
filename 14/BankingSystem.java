import java.util.*;
import java.util.concurrent.*;

class BankAccount {
    private int id;
    private double balance;

    public BankAccount(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public int getId() {
        return id;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("✅ Account " + id + " deposited: " + amount + " | New Balance: " + balance);
    }

    public synchronized boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("❌ Account " + id + " has insufficient funds to withdraw: " + amount);
            return false;
        }
        balance -= amount;
        System.out.println("✅ Account " + id + " withdrew: " + amount + " | New Balance: " + balance);
        return true;
    }

    public synchronized double getBalance() {
        return balance;
    }

    public static void transfer(BankAccount from, BankAccount to, double amount) {
        BankAccount first = from.getId() < to.getId() ? from : to;
        BankAccount second = from.getId() < to.getId() ? to : from;

        synchronized (first) {
            synchronized (second) {
                if (from.withdraw(amount)) {
                    to.deposit(amount);
                    System.out.println("🔁 Transferred " + amount + " from Account " + from.getId() + " to Account " + to.getId());
                } else {
                    System.out.println("❌ Transfer failed from Account " + from.getId() + " due to insufficient funds.");
                }
            }
        }
    }
}

class UserTask implements Runnable {
    private Map<Integer, BankAccount> accounts;
    private List<String> operations;

    public UserTask(Map<Integer, BankAccount> accounts, List<String> operations) {
        this.accounts = accounts;
        this.operations = operations;
    }

    @Override
    public void run() {
        for (String op : operations) {
            String[] parts = op.trim().split(" ");
            String command = parts[0];

            try {
                switch (command) {
                    case "deposit":
                        int accIdD = Integer.parseInt(parts[1]);
                        double amountD = Double.parseDouble(parts[2]);
                        if (accounts.containsKey(accIdD)) {
                            accounts.get(accIdD).deposit(amountD);
                        }
                        break;

                    case "withdraw":
                        int accIdW = Integer.parseInt(parts[1]);
                        double amountW = Double.parseDouble(parts[2]);
                        if (accounts.containsKey(accIdW)) {
                            accounts.get(accIdW).withdraw(amountW);
                        }
                        break;

                    case "transfer":
                        int fromId = Integer.parseInt(parts[1]);
                        int toId = Integer.parseInt(parts[2]);
                        double amountT = Double.parseDouble(parts[3]);
                        if (accounts.containsKey(fromId) && accounts.containsKey(toId)) {
                            BankAccount.transfer(accounts.get(fromId), accounts.get(toId), amountT);
                        }
                        break;
                }

                Thread.sleep(100); // simulate processing delay
            } catch (Exception e) {
                System.out.println("⚠️ Invalid operation format: " + op);
            }
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, BankAccount> accounts = new ConcurrentHashMap<>();

        System.out.println("💰 Welcome to the Multi-threaded Banking System");
        System.out.println("👉 Follow the prompts to create accounts and perform transactions using multiple users (threads).");

        System.out.print("\n🔢 Enter number of accounts: ");
        int numAccounts = scanner.nextInt();

        for (int i = 0; i < numAccounts; i++) {
            System.out.print("📝 Enter account ID and initial balance (e.g. 101 1000): ");
            int id = scanner.nextInt();
            double balance = scanner.nextDouble();
            accounts.put(id, new BankAccount(id, balance));
        }

        System.out.print("\n🔢 Enter number of users (threads): ");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // clear newline

        List<Thread> userThreads = new ArrayList<>();

        for (int i = 0; i < numUsers; i++) {
            System.out.println("\n👤 Enter operations for User " + (i + 1) + ":");
            System.out.println("   👉 Format examples:");
            System.out.println("      - deposit <account_id> <amount>");
            System.out.println("      - withdraw <account_id> <amount>");
            System.out.println("      - transfer <from_account_id> <to_account_id> <amount>");
            System.out.println("   ❌ Type 'end' to finish entering operations for this user.");

            List<String> operations = new ArrayList<>();
            while (true) {
                String op = scanner.nextLine();
                if (op.equalsIgnoreCase("end")) break;
                operations.add(op);
            }
            Thread t = new Thread(new UserTask(accounts, operations));
            userThreads.add(t);
        }

        System.out.println("\n🚀 Starting concurrent transactions...\n");

        for (Thread t : userThreads) t.start();
        for (Thread t : userThreads) {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("\n📊 Final Account Balances:");
        for (BankAccount acc : accounts.values()) {
            System.out.printf("   - Account %d: $%.2f%n", acc.getId(), acc.getBalance());
        }

        System.out.println("\n✅ Transactions completed successfully.");
        scanner.close();
    }
}
