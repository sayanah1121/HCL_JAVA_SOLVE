// Question 100
import java.util.Scanner;

public class CyclicShiftValidation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        int maxLen = 1;
        // all equal
        int current = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                current = 1;
            }
            maxLen = Math.max(maxLen, current);
        }
        // period 2
        for (int i = 0; i < n; i++) {
            int len = 2;
            while (i + len <= n) {
                if (len > 2) {
                    int half = len / 2;
                    if (s.charAt(i + half) != s.charAt(i + len) || s.charAt(i + half + 1) != s.charAt(i + len + 1)) {
                        break;
                    }
                }
                len += 2;
            }
            maxLen = Math.max(maxLen, len - 2);
        }
        int ans = n - maxLen;
        System.out.println(ans);
        sc.close();
    }
}