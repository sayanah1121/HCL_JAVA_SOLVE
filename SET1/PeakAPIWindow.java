// Question 24

import java.util.Scanner;

public class PeakAPIWindow {

    public static int peakAPIWindow(int window, int[] timestamps) {
        int maxRequests = 0;
        int n = timestamps.length;
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Slide the window to ensure timestamps[right] - timestamps[left] < window
            while (timestamps[right] - timestamps[left] >= window) {
                left++;
            }
            maxRequests = Math.max(maxRequests, right - left + 1);
        }

        return maxRequests;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    
        int window = scanner.nextInt();

        int n = scanner.nextInt();

        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }

        int result = peakAPIWindow(window, timestamps);
        System.out.println("Maximum number of requests in any window: " + result);

        scanner.close();
    }
}
// ["authreq001", "authreq002", "authreq001", "authreq002"] 