import java.util.*;

public class MaxRequestInWindow {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of timestamps
        int n = sc.nextInt();
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = sc.nextInt();
        }
        // Input window size
        int windowSize = sc.nextInt();

        System.out.println(maxRequestInWindow(timestamp, windowSize));
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
