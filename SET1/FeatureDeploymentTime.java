// Question 63
import java.util.Scanner;

public class FeatureDeploymentTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] setup = new long[n];
        for (int i = 0; i < n; i++) {
            setup[i] = scanner.nextLong();
        }
        long[] test = new long[n];
        for (int i = 0; i < n; i++) {
            test[i] = scanner.nextLong();
        }
        long k = scanner.nextLong();
        
        long[] prefix = new long[n + 1];
        long[] minTest = new long[n + 1];
        minTest[0] = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + setup[i] + test[i];
            minTest[i + 1] = Math.min(minTest[i], test[i]);
        }
        
        long ans = Long.MAX_VALUE;
        for (int p = 1; p <= Math.min(n, k); p++) {
            long cost = prefix[p] + (k - p) * minTest[p];
            ans = Math.min(ans, cost);
        }
        System.out.println(ans);
        scanner.close();
    }
}