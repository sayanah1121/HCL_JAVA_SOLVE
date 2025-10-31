// Question 83
import java.util.Scanner;

public class MonotonicArrayReduction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        long max = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            max = Math.max(max, arr[i]);
        }
        int increases = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) increases++;
        }
        System.out.println(max + increases);
        scanner.close();
    }
}