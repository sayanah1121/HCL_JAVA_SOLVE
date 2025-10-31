// Question 79
import java.util.Scanner;

public class SwapAndUnite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int minSwaps = Integer.MAX_VALUE;
        for (int f : freq) {
            if (f > 0) {
                minSwaps = Math.min(minSwaps, f / 2);
            }
        }
        System.out.println(minSwaps);
        scanner.close();
    }
}