import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private double balance;

    // Constructor to initialize accountNumber and balance
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Method to withdraw amount
    public void withdraw(double amount) throws ArithmeticException, IllegalArgumentException {
        if (amount <= 0) {
            throw new IllegalArgumentException("Invalid withdrawal amount.");
        }
        if (amount > balance) {
            throw new ArithmeticException("Insufficient funds for withdrawal.");
        }
        balance -= amount; // Deducting the amount from balance
    }

    // Method to get current balance
    public double getBalance() {
        return balance;
    }
}

public class BankAccountDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking account details from user
        System.out.print("Enter Account Number: ");
        String accountNumber = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        // Creating a BankAccount object
        BankAccount account = new BankAccount(accountNumber, initialBalance);

        while (true) {
            try {
                System.out.print("\nEnter amount to withdraw: ");
                double withdrawalAmount = sc.nextDouble();

                // Trying to withdraw the entered amount
                account.withdraw(withdrawalAmount);

                // Display current balance after withdrawal
                System.out.println("Withdrawal successful!");
                System.out.println("Current balance: " + account.getBalance());

            } catch (ArithmeticException e) {
                // Handling insufficient funds exception
                System.out.println("Insufficient funds for withdrawal.");
            } catch (IllegalArgumentException e) {
                // Handling invalid withdrawal amount exception
                System.out.println("Invalid withdrawal amount.");
            }

            // Ask if the user wants to perform another transaction
            System.out.print("\nDo you want to perform another transaction? (yes/no): ");
            sc.nextLine();  // Consumcdcde newline left-over
            String choice = sc.nextLine();
            if (choice.equalsIgnoreCase("no")) {
                break;  // Exit the loop if the user doesn't want to continue
            }
        }

        sc.close();
        System.out.println("Thank you for using our banking service!");
    }
}
