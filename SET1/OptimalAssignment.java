// Question 34
import java.util.Arrays;
import java.util.Scanner;

public class OptimalAssignment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numItems = scanner.nextInt();
        int n = scanner.nextInt();
        int[] itemId = new int[n];
        for (int i = 0; i < n; i++) {
            itemId[i] = scanner.nextInt();
        }
        // The problem description has a redundant 'n' input
        scanner.nextInt(); 
        long[] cost = new long[n];
        for (int i = 0; i < n; i++) {
            cost[i] = scanner.nextLong();
        }

        long[] minCosts = new long[numItems];
        Arrays.fill(minCosts, Long.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            int id = itemId[i];
            if (id < numItems) {
                minCosts[id] = Math.min(minCosts[id], cost[i]);
            }
        }

        long totalCost = 0;
        boolean possible = true;
        for (int i = 0; i < numItems; i++) {
            if (minCosts[i] == Long.MAX_VALUE) {
                possible = false;
                break;
            }
            totalCost += minCosts[i];
        }

        if (possible) {
            System.out.println(totalCost);
        } else {
            System.out.println(-1);
        }

        scanner.close();
    }
}