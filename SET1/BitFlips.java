// Question 87
import java.util.Scanner;

public class BitFlips {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        long k = scanner.nextLong();
        int n = s.length();
        
        char[] result = new char[n];
        long flips_needed = 0;

        // Determine the target state for each bit to be '1'
        // and count the number of flips required.
        for (int i = 0; i < n; i++) {
            char final_char_if_all_ones;
            if (k % 2 == 1) { // Odd k: overall flip
                final_char_if_all_ones = (s.charAt(i) == '0') ? '1' : '0';
            } else { // Even k: no overall flip
                final_char_if_all_ones = s.charAt(i);
            }

            if (final_char_if_all_ones == '0') {
                flips_needed++;
            }
            result[i] = '1'; // Greedily assume we can make everything '1'
        }

        if (k < flips_needed || (k - flips_needed) % 2 != 0) {
            // If we don't have enough flips, or we can't spend the rest in pairs,
            // we must turn some '1's into '0's.
            // To make the string lexicographically largest, we turn the rightmost '1's into '0's.
            long flips_to_conserve = flips_needed > k ? flips_needed - k : 0;
            if ((k - flips_needed) % 2 != 0) {
                 flips_to_conserve++;
            }

            for (int i = n - 1; i >= 0 && flips_to_conserve > 0; i--) {
                 char final_char_if_all_ones;
                if (k % 2 == 1) {
                    final_char_if_all_ones = (s.charAt(i) == '0') ? '1' : '0';
                } else {
                    final_char_if_all_ones = s.charAt(i);
                }

                if (final_char_if_all_ones == '0') {
                    result[i] = '0';
                    flips_to_conserve--;
                }
            }
             for (int i = n - 1; i >= 0 && flips_to_conserve > 0; i--) {
                 result[i] = '0';
                 flips_to_conserve--;
             }
        }

        System.out.println(new String(result));
        scanner.close();
    }
}