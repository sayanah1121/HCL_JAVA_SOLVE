// Question 72
import java.util.Scanner;

public class MaximizeConsecutiveOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                left[i] = 1 + (i > 0 ? left[i - 1] : 0);
            } else {
                left[i] = 0;
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                right[i] = 1 + (i < n - 1 ? right[i + 1] : 0);
            } else {
                right[i] = 0;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                max = Math.max(max, left[i]);
            }
        }
        for (int l = 0; l <= n - k; l++) {
            int r = l + k - 1;
            int cand = k;
            if (l > 0 && s.charAt(l - 1) == '1') {
                cand = Math.max(cand, left[l - 1] + k);
            }
            if (r < n - 1 && s.charAt(r + 1) == '1') {
                cand = Math.max(cand, k + right[r + 1]);
            }
            if (l > 0 && r < n - 1 && s.charAt(l - 1) == '1' && s.charAt(r + 1) == '1') {
                cand = Math.max(cand, left[l - 1] + k + right[r + 1]);
            }
            max = Math.max(max, cand);
        }
        System.out.println(max);
        scanner.close();
    }
}