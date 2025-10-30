// Q 55
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class SEOInputProcessing {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the entire line of text
        String text = scanner.nextLine();

        // Read the integer k
        int k = scanner.nextInt();
        scanner.close();

        // Find the stop words and print them
        List<String> stopWords = findStopWords(text, k);
        for (String word : stopWords) {
            System.out.println(word);
        }
    }

    public static List<String> findStopWords(String text, int k) {
        // 1. Split the text into an array of words
        String[] words = text.split(" ");

        // 2. Count the frequency of each word
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 3. Identify stop words and maintain their first-occurrence order
        // A LinkedHashSet preserves insertion order and prevents duplicates.
        Set<String> resultSet = new LinkedHashSet<>();
        
        for (String word : words) {
            // Check if the word's frequency meets the threshold
            if (wordCounts.get(word) >= k) {
                // Adding to a Set automatically handles duplicates
                resultSet.add(word);
            }
        }

        // Convert the set to a list for the final return value
        return new ArrayList<>(resultSet);
    }
}
