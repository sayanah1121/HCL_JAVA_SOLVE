// Question 3
import java.util.Arrays;
import java.util.Scanner;

public class MaxRequestInWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of timestamps
        int n = scanner.nextInt();
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = scanner.nextInt();
        }
        // Input window size
        int windowSize = scanner.nextInt();

        System.out.println(maxRequestInWindow(timestamp, windowSize));
        scanner.close();
    }

    public static int maxRequestInWindow(int[] timestamp, int windowSize) {
        Arrays.sort(timestamp); // Ensure sorted (problem guarantees ascending).

        int maxCount = 0;
        int start = 0;
        // Sliding window
        for (int end = 0; end < timestamp.length; end++) {
            while (timestamp[end] - timestamp[start] >= windowSize) {
                start++;
            }
            maxCount = Math.max(maxCount, end - start + 1);
        }
        return maxCount;
    }
}
