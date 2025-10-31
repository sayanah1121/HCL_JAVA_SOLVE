// Question 80
import java.util.Scanner;

public class MaximizeArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }

        long[] prefixMax = new long[n];
        prefixMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], arr[i]);
        }

        long[] suffixMax = new long[n];
        suffixMax[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], arr[i]);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(prefixMax[i], suffixMax[i]);
        }
        System.out.println(sum);
        scanner.close();
    }
}