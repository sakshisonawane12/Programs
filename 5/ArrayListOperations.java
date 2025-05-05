import java.util.*;

public class ArrayListOperations{
    public static void main(String[] args) {
        // a. Create an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Add elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        fruits.add("Mango");

        // c. Add element at a specific index
        fruits.add(2, "Orange"); // Adding "Orange" at index 2

        // a. Traverse using for-loop
        System.out.println("Traversal using for-loop:");
        for (int i = 0; i < fruits.size(); i++) {
            System.out.println(fruits.get(i));
        }

        // Traverse using Iterator
        System.out.println("\nTraversal using Iterator:");
        Iterator<String> itr = fruits.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        // Traverse using enhanced for-loop
        System.out.println("\nTraversal using enhanced for-loop:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }

        // b. Check if a value exists
        String searchItem = "Banana";
        if (fruits.contains(searchItem)) {
            System.out.println("\n" + searchItem + " exists in the ArrayList.");
        } else {
            System.out.println("\n" + searchItem + " does not exist in the ArrayList.");
        }

        // Final list
        System.out.println("\nFinal ArrayList: " + fruits);
    }
}

