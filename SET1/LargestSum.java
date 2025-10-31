// Question 71
import java.util.Arrays;
import java.util.Scanner;

public class LargestSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        int negCount = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            if (arr[i] < 0) negCount++;
        }
        long[] absArr = new long[n];
        for (int i = 0; i < n; i++) {
            absArr[i] = Math.abs(arr[i]);
        }
        Arrays.sort(absArr);
        long sum = 0;
        for (long val : absArr) {
            sum += val;
        }
        if (negCount % 2 == 1) {
            sum -= 2 * absArr[0];
        }
        System.out.println(sum);
        scanner.close();
    }
}