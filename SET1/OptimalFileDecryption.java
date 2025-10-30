// Question 60
import java.util.Scanner;

public class OptimalFileDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = scanner.nextInt();
        int[] decryptionStatus = new int[n];
        for (int i = 0; i < n; i++) decryptionStatus[i] = scanner.nextInt();
        int k = scanner.nextInt();
        long initial = 0;
        for (int i = 0; i < n; i++) {
            if (decryptionStatus[i] == 1) initial += scores[i];
        }
        long[] temp = new long[n];
        for (int i = 0; i < n; i++) {
            if (decryptionStatus[i] == 0) temp[i] = scores[i];
        }
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + temp[i];
        }
        long max_added = 0;
        for (int i = 0; i <= n - k; i++) {
            long sum = prefix[i + k] - prefix[i];
            if (sum > max_added) max_added = sum;
        }
        long total = initial + max_added;
        System.out.println(total);
        scanner.close();
    }
}