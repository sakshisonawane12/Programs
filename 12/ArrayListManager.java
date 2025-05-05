import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
System.out.println("Enter a command insert/update/sum");
        // Loop to read and process commands
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            if (input.trim().isEmpty()) break;  // Stop on empty line

            String[] parts = input.split(" ");
            String command = parts[0];

            // Process the command based on the operation
            switch (command) {
                case "insert":
                    int insertIndex = Integer.parseInt(parts[1]);
                    int value = Integer.parseInt(parts[2]);
                    if (insertIndex >= 0 && insertIndex <= list.size()) {
                        list.add(insertIndex, value);
                    } else {
                        System.out.println("Invalid insert index");
                    }
                    System.out.println(list);
                    break;

                case "delete":
                    int deleteIndex = Integer.parseInt(parts[1]);
                    if (deleteIndex >= 0 && deleteIndex < list.size()) {
                        list.remove(deleteIndex);
                    } else {
                        System.out.println("Invalid delete index");
                    }
                    System.out.println(list);
                    break;

                case "update":
                    int updateIndex = Integer.parseInt(parts[1]);
                    int newValue = Integer.parseInt(parts[2]);
                    if (updateIndex >= 0 && updateIndex < list.size()) {
                        list.set(updateIndex, newValue);
                    } else {
                        System.out.println("Invalid update index");
                    }
                    System.out.println(list);
                    break;

                case "sum":
                    int start = Integer.parseInt(parts[1]);
                    int end = Integer.parseInt(parts[2]);
                    if (start >= 0 && end < list.size() && start <= end) {
                        int sum = 0;
                        for (int i = start; i <= end; i++) {
                            sum += list.get(i);
                        }
                        System.out.println(sum);
                    } else {
                        System.out.println("Invalid range for sum");
                    }
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }

        scanner.close();
    }
}
