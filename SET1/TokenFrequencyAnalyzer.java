//  Question 59

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TokenFrequencyAnalyzer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the entire line of text for the prompt
        String prompt = scanner.nextLine();
        scanner.close();

        // Find the most frequent token and print it
        char result = getMostFrequentToken(prompt);
        System.out.println(result);
    }

    public static char getMostFrequentToken(String prompt) {
        // Use a HashMap to store the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        // Use a LinkedHashSet to maintain the order of first appearance
        Set<Character> orderedUniqueChars = new LinkedHashSet<>();

        // First pass: count frequencies and record first appearance order
        for (char c : prompt.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
            orderedUniqueChars.add(c);
        }

        char mostFrequentChar = ' ';
        int maxFrequency = -1;

        // Second pass: iterate through characters in their first-appearance order
        for (char c : orderedUniqueChars) {
            int currentFrequency = frequencyMap.get(c);
            if (currentFrequency > maxFrequency) {
                maxFrequency = currentFrequency;
                mostFrequentChar = c;
            }
        }

        return mostFrequentChar;
    }
}
