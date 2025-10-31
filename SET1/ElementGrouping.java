// Question 86
import java.util.Arrays;
import java.util.Scanner;

public class ElementGrouping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] nums = new long[n];
        for(int i = 0; i < n; i++) {
            nums[i] = scanner.nextLong();
        }
        Arrays.sort(nums);
        long sum = 0;
        int small_ptr = 0;
        for (int i = n - 1; i >= small_ptr + 2; i -= 2) {
            sum += nums[i - 1];
            small_ptr++;
        }
        System.out.println(sum);
        scanner.close();
    }
}