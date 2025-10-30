// Question 30

import java.util.*;

public class CloudFunctionOptimization {

    public static int maximumPoints(int[] functionCosts, int k) {
        int n = functionCosts.length;
        int left = 0;
        long totalCost = 0;
        int skipped = 0;
        int maxPoints = 0;

        for (int right = 0; right < n; right++) {
            totalCost += functionCosts[right];

            // While over budget and can only skip one
            while (totalCost > k && left <= right) {
                if (skipped == 0) { 
                    // Try skipping one function (simulate removing the largest in window)
                    int maxCost = 0, maxIndex = left;
                    for (int i = left; i <= right; i++) {
                        if (functionCosts[i] > maxCost) {
                            maxCost = functionCosts[i];
                            maxIndex = i;
                        }
                    }
                    totalCost -= maxCost;
                    skipped = 1; // used skip
                } else {
                    // move window if still over budget
                    totalCost -= functionCosts[left];
                    left++;
                }
            }

            maxPoints = Math.max(maxPoints, right - left + 1 - skipped);
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int n = scanner.nextInt();

        int[] functionCosts = new int[n];
        for (int i = 0; i < n; i++) {
            functionCosts[i] = scanner.nextInt();
        }

        int result = maximumPoints(functionCosts, k);
        System.out.println("Maximum number of functions that can be run: " + result);
        scanner.close();
    }
}
