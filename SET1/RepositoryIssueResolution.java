// Question 32
import java.util.Arrays;
import java.util.Scanner;

public class RepositoryIssueResolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] resolved = new long[n];
        for (int i = 0; i < n; i++) {
            resolved[i] = scanner.nextLong();
        }
        scanner.nextInt(); // skip duplicate n
        long[] required = new long[n];
        for (int i = 0; i < n; i++) {
            required[i] = scanner.nextLong();
        }
        long k = scanner.nextLong();
        long[] needs = new long[n];
        for (int i = 0; i < n; i++) {
            needs[i] = Math.max(0, required[i] - resolved[i]);
        }
        Arrays.sort(needs);
        long sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (sum + needs[i] <= k) {
                sum += needs[i];
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}