// Question 70
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptimalSubarrayRemoval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        int maxLen = 0;
        int current = 0;
        for (int num : arr) {
            if (freq.get(num) == 1) {
                current++;
                maxLen = Math.max(maxLen, current);
            } else {
                current = 0;
            }
        }
        System.out.println(maxLen);
        scanner.close();
    }
}