// Question 74
import java.util.Arrays;
import java.util.Scanner;

public class SubsequenceUpdate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextLong();
        int l = scanner.nextInt();
        int r = scanner.nextInt();
        int k = r - l + 1;
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < k; i++) sum += arr[i];
        System.out.println(sum);
        scanner.close();
    }
}