// Question 68
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryStringReordering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        sc.close();

        // Check if both strings have same number of 0s and 1s
        int count0_s = 0, count0_t = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') count0_s++;
            if (t.charAt(i) == '0') count0_t++;
        }
        
        if (count0_s != count0_t) {
            System.out.println(-1);
            return;
        }
        
        // Build a mapping: where each '0' in s should go to in t
        List<Integer> s_zeros = new ArrayList<>();
        List<Integer> t_zeros = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') s_zeros.add(i);
            if (t.charAt(i) == '0') t_zeros.add(i);
        }
        
        // Count the minimum number of swaps needed
        // Each swap moves a '0' by jumping over consecutive '1's
        int operations = 0;
        char[] current = s.toCharArray();
        
        for (int k = 0; k < s_zeros.size(); k++) {
            // Find where the k-th '0' currently is in current
            int currentPos = -1;
            int zeroCount = 0;
            for (int i = 0; i < current.length; i++) {
                if (current[i] == '0') {
                    if (zeroCount == k) {
                        currentPos = i;
                        break;
                    }
                    zeroCount++;
                }
            }
            
            int targetPos = t_zeros.get(k);
            
            // Move the '0' from currentPos to targetPos
            while (currentPos != targetPos) {
                if (currentPos < targetPos) {
                    // Move right: swap with the rightmost '1' in the sequence
                    int j = currentPos + 1;
                    while (j <= targetPos && current[j] == '1') {
                        j++;
                    }
                    if (j - 1 >= currentPos + 1) {
                        // Swap current[currentPos] with current[j-1]
                        current[currentPos] = '1';
                        current[j - 1] = '0';
                        currentPos = j - 1;
                        operations++;
                    } else {
                        // Can't move right
                        System.out.println(-1);
                        return;
                    }
                } else {
                    // Move left: swap with the leftmost '1' in the sequence
                    int j = currentPos - 1;
                    while (j >= targetPos && current[j] == '1') {
                        j--;
                    }
                    if (j + 1 <= currentPos - 1) {
                        // Swap current[currentPos] with current[j+1]
                        current[currentPos] = '1';
                        current[j + 1] = '0';
                        currentPos = j + 1;
                        operations++;
                    } else {
                        // Can't move left
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }
        
        System.out.println(operations);
    }
}