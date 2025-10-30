// Question 44
import java.util.Scanner;

public class MinimumOperationsToPalindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int mismatches = 0;
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                mismatches++;
            }
        }
        if (n % 2 == 0) {
            int left_ones = 0;
            for (int i = 0; i < n / 2; i++) {
                if (s.charAt(i) == '1') left_ones++;
            }
            int right_ones = 0;
            for (int i = n / 2; i < n; i++) {
                if (s.charAt(i) == '1') right_ones++;
            }
            if ((left_ones - right_ones) % 2 != 0) {
                System.out.println(-1);
                scanner.close();
                return;
            }
        }
        int ans = (mismatches + 1) / 2;
        System.out.println(ans);
        scanner.close();
    }
}