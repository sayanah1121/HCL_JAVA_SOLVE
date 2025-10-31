// Question 78
import java.util.Scanner;

public class LargestString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int pairs = 0;
        for (int f : freq) {
            pairs += f / 2;
        }
        int maxLength = pairs * 2;
        int removals = s.length() - maxLength;
        System.out.println(removals);
        scanner.close();
    }
}