// Question 66
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CostEfficientTaskCleanup {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Long> costs = new ArrayList<>();
        for (int i = 0; i < n; i++) costs.add(scanner.nextLong());
        Collections.sort(costs, Collections.reverseOrder());
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) prefix[i] = prefix[i - 1] + costs.get(i - 1);
        int operationsPerBundle = scanner.nextInt();
        int bundleCost = scanner.nextInt();
        long min = Long.MAX_VALUE;
        for (int k = 0; k <= n; k++) {
            long retained = prefix[n] - prefix[k];
            long bundles = (k + (long)operationsPerBundle - 1) / operationsPerBundle;
            long total = retained + bundles * bundleCost;
            if (total < min) min = total;
        }
        System.out.println(min);
        scanner.close();
    }
}