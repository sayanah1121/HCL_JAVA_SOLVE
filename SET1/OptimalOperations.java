// Question 97
import java.util.Scanner;

public class OptimalOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = sc.nextInt();
        int ans = 0;
        if (m == 1) {
            for (char c : s.toCharArray()) {
                if (c == '0') ans++;
            }
        } else {
            int maxRun = 0;
            int current = 0;
            for (char c : s.toCharArray()) {
                if (c == '0') {
                    current++;
                    maxRun = Math.max(maxRun, current);
                } else {
                    current = 0;
                }
            }
            if (maxRun >= m) ans = 1;
        }
        System.out.println(ans);
        sc.close();
    }
}