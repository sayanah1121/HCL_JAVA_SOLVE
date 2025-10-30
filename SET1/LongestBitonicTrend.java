// Question 28

import java.util.*;

public class LongestBitonicTrend {

    public static int longestBitonicTrend(int[] trends) {
        int n = trends.length;
        if (n == 0) return 0;

        int[] inc = new int[n]; // increasing sequence lengths
        int[] dec = new int[n]; // decreasing sequence lengths

        // Build increasing sequence length array
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            if (trends[i] >= trends[i - 1])
                inc[i] = inc[i - 1] + 1;
            else
                inc[i] = 1;
        }

        // Build decreasing sequence length array
        dec[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            if (trends[i] >= trends[i + 1])
                dec[i] = dec[i + 1] + 1;
            else
                dec[i] = 1;
        }

        // Find maximum bitonic length
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            int bitonicLen = inc[i] + dec[i] - 1;
            maxLen = Math.max(maxLen, bitonicLen);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        int n = sc.nextInt();
        int[] trends = new int[n];

        
        for (int i = 0; i < n; i++) {
            trends[i] = sc.nextInt();
        }

        int result = longestBitonicTrend(trends);
        System.out.println("Length of longest bitonic subarray: " + result);
    }
}
