// Q 52
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class OptimalScoreBand {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of model scores
        int n = scanner.nextInt();
        int[] modelScores = new int[n];

        // Read each score
        for (int i = 0; i < n; i++) {
            modelScores[i] = scanner.nextInt();
        }
        scanner.close();

        // Calculate and print the size of the largest score band
        int result = findLargestScoreBand(modelScores);
        System.out.println(result);
    }

    public static int findLargestScoreBand(int[] modelScores) {
        if (modelScores == null || modelScores.length == 0) {
            return 0;
        }

        // Use a TreeMap to store score frequencies, which keeps the keys (scores) sorted.
        Map<Integer, Integer> freqMap = new TreeMap<>();
        for (int score : modelScores) {
            freqMap.put(score, freqMap.getOrDefault(score, 0) + 1);
        }

        int maxBandSize = 0;
        int currentBandSize = 0;
        int prevScore = -2; // Initialize with a value that cannot be a score + 1

        // Iterate through the sorted scores from the TreeMap
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int currentScore = entry.getKey();
            int currentFreq = entry.getValue();

            // Check if the current score continues the previous band
            if (currentScore == prevScore + 1) {
                // If it's a consecutive number, add its frequency to the current band
                currentBandSize += currentFreq;
            } else {
                // Otherwise, the band is broken; start a new one with the current score's frequency
                currentBandSize = currentFreq;
            }

            // Update the maximum band size found so far
            maxBandSize = Math.max(maxBandSize, currentBandSize);
            
            // Update the previous score for the next iteration
            prevScore = currentScore;
        }

        return maxBandSize;
    }
}
