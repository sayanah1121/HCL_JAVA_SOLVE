// Question 112

import java.util.Arrays;
import java.util.Scanner;

public class PersonalizedGrouping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        int[] engagementScores = new int[n];
        
        // Read engagement scores
        for (int i = 0; i < n; i++) {
            engagementScores[i] = scanner.nextInt();
        }
        
        // Sort the array
        Arrays.sort(engagementScores);
        
        // Find the maximum group size using sliding window
        int maxSize = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            // While the window is invalid, move left
            while (engagementScores[right] - engagementScores[left] > right - left) {
                left++;
            }
            // Update max size
            maxSize = Math.max(maxSize, right - left + 1);
        }
        
        System.out.println(maxSize);
        
        scanner.close();
    }
}