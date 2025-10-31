// Question 77
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class SmallestValidSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int[] pos = new int[n + 1];
        for (int i = 0; i < n; i++) {
            pos[arr[i]] = i;
        }

        int[] positions = new int[n];
        for (int i = 1; i <= n; i++) {
            positions[i - 1] = pos[i];
        }

        // Sliding window for min and max
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            // Add positions[i] to deques
            while (!maxDeque.isEmpty() && positions[maxDeque.peekLast()] <= positions[i]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(i);
            while (!minDeque.isEmpty() && positions[minDeque.peekLast()] >= positions[i]) {
                minDeque.pollLast();
            }
            minDeque.addLast(i);

            // Remove out of window
            if (maxDeque.peekFirst() == i - k) {
                maxDeque.pollFirst();
            }
            if (minDeque.peekFirst() == i - k) {
                minDeque.pollFirst();
            }

            // If window size >= k
            if (i >= k - 1) {
                int maxPos = positions[maxDeque.peekFirst()];
                int minPos = positions[minDeque.peekFirst()];
                int length = maxPos - minPos + 1;
                if (length < minLength) {
                    minLength = length;
                }
            }
        }

        System.out.println(minLength);
        scanner.close();
    }
}