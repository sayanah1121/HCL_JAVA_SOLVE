// Question 73
import java.util.Scanner;

public class OptimalSubarrayDeletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) pos[arr[i]] = i;
        int min_pos = Integer.MAX_VALUE;
        int max_pos = Integer.MIN_VALUE;
        int max_len = 0;
        for (int num = n; num >= 1; num--) {
            min_pos = Math.min(min_pos, pos[num]);
            max_pos = Math.max(max_pos, pos[num]);
            int span = max_pos - min_pos + 1;
            int count = n - num + 1;
            if (count < n && span == count) {
                max_len = Math.max(max_len, count);
            }
        }
        System.out.println(max_len);
        scanner.close();
    }
}