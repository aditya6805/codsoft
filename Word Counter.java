import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class WordCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read input from the user or file
        String input = Inputread(sc);

        Map<String, Integer> wordCount = countWords(input);

        CountWord(wordCount);

        sc.close();
    }

    private static String Inputread(Scanner sc) {
        System.out.println("Enter text or file path:");
        String input = sc.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("No input provided. Exiting.");
            System.exit(0);
        } else if (input.endsWith(".txt")) {
            try {
                // Read content from file
                input = new String(Files.readAllBytes(new File(input).toPath()));
            } catch (IOException e) {
                System.err.println("Error reading file. Exiting.");
                System.exit(1);
            }
        }

        return input;
    }

    private static Map<String, Integer> countWords(String input) {
        Map<String, Integer> wordCount = new HashMap<>();

        // Split the input into words using space punctuation
        String[] words = input.split("\\s+");

        String[] stopWords = {"the", "and", "is", "of", "in", "to", "a", "for", "on", "with", "at"};

        // Count occurrences of each word
        for (String word : words) {
            
            String lowercase = word.toLowerCase();

            // Ignore common stop words
            if (!isStopWord(lowercase, stopWords)) {
                
                wordCount.put(lowercase, wordCount.getOrDefault(lowercase, 0) + 1);
            }
        }

        return wordCount;
    }

    private static boolean isStopWord(String word, String[] stopWords) {
        for (String stopWord : stopWords) {
            if (word.equals(stopWord)) {
                return true;
            }
        }
        return false;
    }

    private static void CountWord(Map<String, Integer> wordCount) {
        System.out.println("Word Counts:");
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
