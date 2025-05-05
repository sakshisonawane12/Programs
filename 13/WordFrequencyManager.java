import java.util.*;

public class WordFrequencyManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Integer> freqMap = new HashMap<>();
     System.out.println("Enter the Command add / remove /query /mostFrequent");
     
        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) break;

            String[] parts = input.split(" ");
            String command = parts[0];

            switch (command) {
                case "add":
                    String addWord = parts[1];
                    freqMap.put(addWord, freqMap.getOrDefault(addWord, 0) + 1);
                    break;

                case "remove":
                    String removeWord = parts[1];
                    freqMap.put(removeWord, Math.max(0, freqMap.getOrDefault(removeWord, 0) - 1));
                    if (freqMap.get(removeWord) == 0) {
                        freqMap.remove(removeWord);
                    }
                    break;

                case "query":
                    String queryWord = parts[1];
                    System.out.println("Frequency of '" + queryWord + "': " + freqMap.getOrDefault(queryWord, 0));
                    break;

                case "mostFrequent":
                    if (freqMap.isEmpty()) {
                        System.out.println("Most frequent word: None");
                        break;
                    }
                    int maxFreq = 0;
                    String mostFrequent = "";
                    for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
                        String word = entry.getKey();
                        int freq = entry.getValue();
                        if (freq > maxFreq || (freq == maxFreq && word.compareTo(mostFrequent) < 0)) {
                            maxFreq = freq;
                            mostFrequent = word;
                        }
                    }
                    System.out.println("Most frequent word: " + mostFrequent);
                    break;

                default:
                    System.out.println("Unknown command");
            }
        }
        scanner.close();
    }
}
