import java.util.Scanner;

// Custom exception class for insufficient funds
class InsufficientFundsException extends Exception {
    // Constructor accepting custom error message
    public InsufficientFundsException(String message) {
        super(message);  // Call the constructor of the Exception class
    }
}

// BankAccount class to handle user withdrawals
class BankAccount {
    double balance;

    // Constructor to initialize balance
    public BankAccount(double balance) {
        this.balance = balance;
    }

    // Method to withdraw an amount from the account
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        } else {
            balance -= amount;  // Deduct the withdrawal amount from the balance
            System.out.println("Withdrawal successful! New balance: " + balance);
        }
    }
}

public class BankingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a BankAccount object with an initial balance
        System.out.print("Enter initial balance: ");
        double initialBalance = sc.nextDouble();
        BankAccount account = new BankAccount(initialBalance);

        // Try to withdraw amounts
        while (true) {
            try {
                // Taking user input for withdrawal amount
                System.out.print("\nEnter withdrawal amount (enter -1 to exit): ");
                double withdrawalAmount = sc.nextDouble();

                // Exit condition for the loop
                if (withdrawalAmount == -1) {
                    break;
                }

                // Attempt to withdraw the amount
                account.withdraw(withdrawalAmount);

            } catch (InsufficientFundsException e) {
                // Catch the custom exception and display the error message
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}

