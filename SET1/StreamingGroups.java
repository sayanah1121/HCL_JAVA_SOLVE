// Question 89
import java.util.Arrays;
import java.util.Scanner;

public class StreamingGroups {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] engagementScores = new int[n];
        for (int i = 0; i < n; i++) {
            engagementScores[i] = scanner.nextInt();
        }
        int minWatchPartyScore = scanner.nextInt();
        
        // Sort in descending order
        Arrays.sort(engagementScores);
        for (int i = 0; i < n / 2; i++) {
            int temp = engagementScores[i];
            engagementScores[i] = engagementScores[n - 1 - i];
            engagementScores[n - 1 - i] = temp;
        }
        
        int count = 0;
        int i = 0;
        while (i < n) {
            int currentMin = engagementScores[i];
            int j = i;
            while (j < n && (long)(j - i + 1) * currentMin < minWatchPartyScore) {
                j++;
                if (j < n) {
                    currentMin = Math.min(currentMin, engagementScores[j]);
                }
            }
            if (j < n) {
                // Can form party from i to j
                count++;
                i = j + 1;
            } else {
                // Cannot, skip i
                i++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}