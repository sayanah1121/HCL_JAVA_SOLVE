// Question 64
import java.util.Scanner;

public class MaximizeTheEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n = s.length();
        int count0 = 0, count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        int pairs = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) pairs++;
        }
        int maxPairs = Math.max(pairs, Math.max(count0 - 1, count1 - 1));
        System.out.println(maxPairs);
        scanner.close();
    }
}