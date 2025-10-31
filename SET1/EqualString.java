// Question 85
import java.util.Arrays;
import java.util.Scanner;

public class EqualString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int n = str1.length();
        if (str2.length() != n) {
            System.out.println(-1);
            scanner.close();
            return;
        }
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (char c : str1.toCharArray()) freq1[c - 'a']++;
        for (char c : str2.toCharArray()) freq2[c - 'a']++;
        if (!Arrays.equals(freq1, freq2)) {
            System.out.println(-1);
            scanner.close();
            return;
        }
        for (int k = n; k >= 0; k--) {
            if (str1.substring(n - k).equals(str2.substring(0, k))) {
                System.out.println(n - k);
                scanner.close();
                return;
            }
        }
        System.out.println(-1);
        scanner.close();
    }
}