// Question 91

import java.util.ArrayList;
import java.util.Scanner;

public class CountSubarrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read n
        int n = scanner.nextInt();
        int[] arr = new int[n];
        
        // Read array
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Positions for each value
        ArrayList<ArrayList<Integer>> pos = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            pos.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            pos.get(arr[i]).add(i);
        }
        
        // Count valid subarrays
        long count = 0;
        for (int l = 1; l <= n; l++) {
            if (pos.get(l).isEmpty()) continue;
            ArrayList<Integer> p = pos.get(l);
            long total = n - l + 1L;
            long invalid = 0;
            
            // Gap before first
            int start = 0;
            int end = p.get(0) - 1;
            int gap = end - start + 1;
            if (gap >= l) invalid += gap - l + 1L;
            
            // Gaps between
            for (int j = 0; j < p.size() - 1; j++) {
                start = p.get(j) + 1;
                end = p.get(j + 1) - 1;
                gap = end - start + 1;
                if (gap >= l) invalid += gap - l + 1L;
            }
            
            // Gap after last
            start = p.get(p.size() - 1) + 1;
            end = n - 1;
            gap = end - start + 1;
            if (gap >= l) invalid += gap - l + 1L;
            
            count += total - invalid;
        }
        
        // Output
        System.out.println(count);
        
        scanner.close();
    }
}