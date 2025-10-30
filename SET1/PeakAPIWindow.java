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
        Scanner sc = new Scanner(System.in);

    
        int window = sc.nextInt();

        int n = sc.nextInt();

        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = sc.nextInt();
        }

        int result = peakAPIWindow(window, timestamps);
        System.out.println("Maximum number of requests in any window: " + result);

        sc.close();
    }
}
// ["authreq001", "authreq002", "authreq001", "authreq002"] 