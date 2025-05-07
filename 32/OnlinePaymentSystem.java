import java.util.Scanner;

// Abstract class Payment
abstract class Payment {
    double amount;
    String transactionID;

    // Constructor to initialize amount and transactionID
    public Payment(double amount, String transactionID) {
        this.amount = amount;
        this.transactionID = transactionID;
    }

    // Abstract method to process payment
    public abstract void processPayment();

    // Concrete method to show transaction details
    public void showTransactionDetails() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Amount: " + amount);
    }
}

// CreditCardPayment subclass
class CreditCardPayment extends Payment {
    String cardNumber;
    String CVV;
    String expiryDate;

    public CreditCardPayment(double amount, String transactionID, String cardNumber, String CVV, String expiryDate) {
        super(amount, transactionID);
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expiryDate = expiryDate;
    }

    // Implement processPayment for CreditCardPayment
    @Override
    public void processPayment() {
        System.out.println("Processing Credit Card Payment...");
        showTransactionDetails();
        System.out.println("Payment Processed via Credit Card.");
    }
}

// PayPalPayment subclass
class PayPalPayment extends Payment {
    String email;
    String password;

    public PayPalPayment(double amount, String transactionID, String email, String password) {
        super(amount, transactionID);
        this.email = email;
        this.password = password;
    }

    // Implement processPayment for PayPalPayment
    @Override
    public void processPayment() {
        System.out.println("Processing PayPal Payment...");
        showTransactionDetails();
        System.out.println("Payment Processed via PayPal.");
    }
}

// UPIPayment subclass
class UPIPayment extends Payment {
    String UPI_ID;

    public UPIPayment(double amount, String transactionID, String UPI_ID) {
        super(amount, transactionID);
        this.UPI_ID = UPI_ID;
    }

    // Implement processPayment for UPIPayment
    @Override
    public void processPayment() {
        System.out.println("Processing UPI Payment...");
        showTransactionDetails();
        System.out.println("Payment Processed via UPI.");
    }
}

// PaymentGateway class to process transactions dynamically
class PaymentGateway {

    // Method to process any payment type dynamically
    public void process(Payment payment) {
        payment.processPayment();
    }
}

// Main class to test the system
public class OnlinePaymentSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for Payment Method
        System.out.println("Choose payment method (1: Credit Card, 2: PayPal, 3: UPI): ");
        int choice = sc.nextInt();
        sc.nextLine();  // consume newline

        // Get common payment details
        System.out.print("Enter amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();  // consume newline

        System.out.print("Enter transaction ID: ");
        String transactionID = sc.nextLine();

        Payment payment = null;

        // Based on choice, ask for specific payment method details and create the appropriate object
        switch (choice) {
            case 1:
                // Credit Card Payment
                System.out.print("Enter card number: ");
                String cardNumber = sc.nextLine();
                System.out.print("Enter CVV: ");
                String CVV = sc.nextLine();
                System.out.print("Enter expiry date (MM/YY): ");
                String expiryDate = sc.nextLine();
                payment = new CreditCardPayment(amount, transactionID, cardNumber, CVV, expiryDate);
                break;

            case 2:
                // PayPal Payment
                System.out.print("Enter PayPal email: ");
                String email = sc.nextLine();
                System.out.print("Enter PayPal password: ");
                String password = sc.nextLine();
                payment = new PayPalPayment(amount, transactionID, email, password);
                break;

            case 3:
                // UPI Payment
                System.out.print("Enter UPI ID: ");
                String UPI_ID = sc.nextLine();
                payment = new UPIPayment(amount, transactionID, UPI_ID);
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }

        // Process the payment if valid
        if (payment != null) {
            PaymentGateway paymentGateway = new PaymentGateway();
            paymentGateway.process(payment);
        }

        sc.close();
    }
}
