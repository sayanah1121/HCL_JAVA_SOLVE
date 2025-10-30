// Question 26

import java.util.*;

public class MaxOfSubarrayMinimums {
    public static int maximumSubarrayMinimum(int[] arr, int k) {
        Deque<Integer> dq = new LinkedList<>();
        List<Integer> minValues = new ArrayList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of this window
            while (!dq.isEmpty() && dq.peek() < i - k + 1) {
                dq.poll();
            }
            // Remove all larger elements as they are not useful
            while (!dq.isEmpty() && arr[dq.peekLast()] >= arr[i]) {
                dq.pollLast();
            }
            dq.offer(i);
            // Starting to record minimums when i >= k-1
            if (i >= k - 1) {
                minValues.add(arr[dq.peek()]);
            }
        }
        // Find max among all minimums
        int maxMin = Integer.MIN_VALUE;
        for (int val : minValues) {
            if (val > maxMin)
                maxMin = val;
        }
        return maxMin;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];
    
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        int result = maximumSubarrayMinimum(arr, k);
        System.out.println("Maximum among all subarray minimums: " + result);
        scanner.close();
    }
}
