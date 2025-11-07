// Question 92

import java.util.Arrays;
import java.util.Scanner;

public class ServerMemoryAllocation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        long[] memoryRequirement = new long[n];
        for (int i = 0; i < n; i++) {
            memoryRequirement[i] = scanner.nextLong();
        }
        long[] memoryAvailable = new long[n - 1];
        for (int i = 0; i < n - 1; i++) {
            memoryAvailable[i] = scanner.nextLong();
        }
        
        // Sort both arrays
        Arrays.sort(memoryRequirement);
        Arrays.sort(memoryAvailable);
        
        // Binary search for the minimum capacity
        int low = 0, high = n - 1;
        long result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (canAssign(memoryRequirement, memoryAvailable, mid)) {
                result = memoryRequirement[mid];
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        // Output
        System.out.println(result);
        
        scanner.close();
    }
    
    private static boolean canAssign(long[] p, long[] s, int skip) {
        int i = 0, j = 0;
        while (i < p.length && j < s.length) {
            if (i == skip) {
                i++;
                continue;
            }
            if (p[i] <= s[j]) {
                i++;
                j++;
            } else {
                return false;
            }
        }
        return j == s.length;
    }
}