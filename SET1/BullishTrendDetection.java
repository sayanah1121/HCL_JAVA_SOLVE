// Question 29

import java.util.*;

public class BullishTrendDetection {

    public static int calculateBullishTrends(int[] stockPrices, int k) {
        int n = stockPrices.length;
        if (k == 1) return n;  // every single element forms a bullish trend of size 1

        int count = 0;
        int increasingLen = 1;

        for (int i = 1; i < n; i++) {
            if (stockPrices[i] > stockPrices[i - 1]) {
                increasingLen++;
            } else {
                increasingLen = 1;
            }

            // once we have at least k length increasing sequence
            if (increasingLen >= k) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stockPrices = new int[n];

        for (int i = 0; i < n; i++) {
            stockPrices[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        int result = calculateBullishTrends(stockPrices, k);
        System.out.println("Number of bullish trends of size : " + result);
    }
}
