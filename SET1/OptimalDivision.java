// Question 95

import java.util.Scanner;

public class OptimalDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] arr = new int[n];
        int[] count = new int[n + 1];
        int maxFreq = 0;
        for(int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            count[arr[i]]++;
            maxFreq = Math.max(maxFreq, count[arr[i]]);
        }
        
        int denom = 2 * maxFreq - 1;
        int ans = (n + denom - 1) / denom;
        
        System.out.println(ans);
        
        scanner.close();
    }
}