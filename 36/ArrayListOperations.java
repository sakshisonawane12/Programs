import java.util.*;

public class ArrayListOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        // a. User input to create ArrayList
        System.out.println("Enter elements (type 'stop' to finish):");
        while (true) {
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("stop")) break;
            list.add(input);
        }

        // a. Traverse using for-loop
        System.out.println("Using for-loop:");
        for (int i = 0; i < list.size(); i++) System.out.println(list.get(i));

        // a. Traverse using enhanced for-loop
        System.out.println("Using enhanced for-loop:");
        for (String item : list) System.out.println(item);

        // a. Traverse using iterator
        System.out.println("Using iterator:");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) System.out.println(it.next());

        // b. Check if value exists
        System.out.print("Enter value to search: ");
        String search = sc.nextLine();
        System.out.println(search + " exists? " + list.contains(search));

        // c. Add element at specific index
        System.out.print("Enter index to insert new element: ");
        int index = sc.nextInt(); sc.nextLine(); // consume leftover newline
        System.out.print("Enter element to insert: ");
        String newElement = sc.nextLine();
        if (index >= 0 && index <= list.size()) {
            list.add(index, newElement);
            System.out.println("Updated list: " + list);
        } else {
            System.out.println("Invalid index.");
        }
    }
}
