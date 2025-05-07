import java.util.*;

class InvalidCouponException extends Exception {
    public InvalidCouponException(String message) {
        super(message);
    }
}

class OutOfStockException extends Exception {
    public OutOfStockException(String message) {
        super(message);
    }
}

class NegativeQuantityException extends Exception {
    public NegativeQuantityException(String message) {
        super(message);
    }
}

class Item {
    String name;
    double price;
    int stock;

    public Item(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

class ShoppingCart {
    Map<String, Item> catalog;
    Map<String, Integer> cart;
    double discount;

    public ShoppingCart(Map<String, Item> catalog) {
        this.catalog = catalog;
        this.cart = new HashMap<>();
        this.discount = 0;
    }

    public void addItem(String itemName, int quantity, Scanner scanner) throws OutOfStockException, NegativeQuantityException {
        if (quantity <= 0) {
            throw new NegativeQuantityException("Quantity must be greater than 0.");
        }

        Item item = catalog.get(itemName);

        // If item not found, ask to create it
        if (item == null) {
            System.out.println("❓ Item not in catalog. Would you like to add it? (yes/no)");
            String response = scanner.nextLine().trim().toLowerCase();
            if (response.equals("yes")) {
                System.out.print("Enter price: ");
                double price = scanner.nextDouble();
                System.out.print("Enter stock: ");
                int stock = scanner.nextInt();
                scanner.nextLine(); // consume newline
                item = new Item(itemName, price, stock);
                catalog.put(itemName, item);
                System.out.println("✅ Item added to catalog.");
            } else {
                System.out.println("❌ Item not added.");
                return;
            }
        }

        if (quantity > item.stock) {
            throw new OutOfStockException("Not enough stock for item: " + itemName);
        }

        cart.put(itemName, cart.getOrDefault(itemName, 0) + quantity);
        item.stock -= quantity;
        System.out.println("✅ Added " + quantity + " " + itemName + "(s) to cart.");
    }

    public void applyCoupon(String code) throws InvalidCouponException {
        Map<String, Double> coupons = Map.of(
            "SAVE10", 0.10,
            "SAVE20", 0.20,
            "FREESHIP", 0.05
        );

        if (!coupons.containsKey(code)) {
            throw new InvalidCouponException("Invalid coupon code.");
        }

        discount = coupons.get(code);
        System.out.println("✅ Coupon applied! Discount: " + (int)(discount * 100) + "%");
    }

    public void checkout() {
        double total = 0;
        if (cart.isEmpty()) {
            System.out.println("🛒 Your cart is empty!");
            return;
        }

        System.out.println("\n🛒 Cart Summary:");
        for (String itemName : cart.keySet()) {
            Item item = catalog.get(itemName);
            int quantity = cart.get(itemName);
            double itemTotal = item.price * quantity;
            total += itemTotal;
            System.out.println(" - " + itemName + " x" + quantity + " = $" + itemTotal);
        }

        double discountAmount = total * discount;
        double finalTotal = total - discountAmount;

        System.out.printf("💵 Subtotal: $%.2f\n", total);
        System.out.printf("🔻 Discount: $%.2f\n", discountAmount);
        System.out.printf("✅ Total Due: $%.2f\n", finalTotal);
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Item> catalog = new HashMap<>();

        // Predefined items (optional)
        catalog.put("apple", new Item("apple", 2.5, 10));
        catalog.put("banana", new Item("banana", 1.2, 5));
        catalog.put("milk", new Item("milk", 3.0, 8));

        ShoppingCart cart = new ShoppingCart(catalog);

        System.out.println("🛍️ Welcome to the Shopping Cart System!");
        System.out.println("📦 You can add any item. Pre-added: apple, banana, milk");

        while (true) {
            System.out.println("\n📋 Choose an option: add / coupon / checkout / exit");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "add":
                    System.out.print("Enter item name: ");
                    String item = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter quantity: ");
                    int qty = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    try {
                        cart.addItem(item, qty, scanner);
                    } catch (OutOfStockException | NegativeQuantityException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case "coupon":
                    System.out.print("Enter coupon code (SAVE10, SAVE20, FREESHIP): ");
                    String code = scanner.nextLine().trim().toUpperCase();
                    try {
                        cart.applyCoupon(code);
                    } catch (InvalidCouponException e) {
                        System.out.println("❌ " + e.getMessage());
                    }
                    break;

                case "checkout":
                    cart.checkout();
                    break;

                case "exit":
                    System.out.println("👋 Thank you for shopping!");
                    scanner.close();
                    return;

                default:
                    System.out.println("⚠️ Invalid command. Please try again.");
            }
        }
    }
}
