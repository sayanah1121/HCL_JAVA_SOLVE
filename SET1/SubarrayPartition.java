// Question 35
import java.util.Scanner;

public class SubarrayPartition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        int minLen = scanner.nextInt();
        long threshold = scanner.nextLong();
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int count = 0;
        int i = 0;
        while (i < n) {
            boolean found = false;
            for (int j = i + minLen - 1; j < n; j++) {
                if (prefix[j + 1] - prefix[i] >= threshold) {
                    count++;
                    i = j + 1;
                    found = true;
                    break;
                }
            }
            if (!found) {
                i++;
            }
        }
        System.out.println(count);
        scanner.close();
    }
}