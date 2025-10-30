// Question 43
import java.util.Scanner;

public class GitCommits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] commits = new long[n];
        for (int i = 0; i < n; i++) {
            commits[i] = scanner.nextLong();
        }
        int maxHidden = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean isConsecutive = true;
                for (int k = i + 1; k <= j; k++) {
                    if (commits[k] != commits[k - 1] + 1) {
                        isConsecutive = false;
                        break;
                    }
                }
                if (!isConsecutive) continue;
                boolean valid = false;
                if (i == 0 && j < n - 1) {
                    if (commits[j + 1] - commits[0] == j + 1) valid = true;
                } else if (j == n - 1 && i > 0) {
                    if (commits[n - 1] - commits[i - 1] == n - i) valid = true;
                } else if (i > 0 && j < n - 1) {
                    if (commits[j + 1] - commits[i - 1] == j - i + 2) valid = true;
                }
                if (valid) {
                    int len = j - i + 1;
                    if (len > maxHidden) maxHidden = len;
                }
            }
        }
        System.out.println(maxHidden);
        scanner.close();
    }
}