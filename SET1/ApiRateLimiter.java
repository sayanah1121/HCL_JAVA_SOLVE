// Question 5
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ApiRateLimiter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of requests
        int n = scanner.nextInt();
        int[] user = new int[n];
        for (int i = 0; i < n; i++) {
            user[i] = scanner.nextInt();
        }
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();

        int[] result = getAllowedRequests(user, timestamp, k);
        for (int val : result)
            System.out.println(val);
        scanner.close();
    }

    // Implementation of the API rate limiter
    public static int[] getAllowedRequests(int[] user, int[] timestamp, int k) {
        Map<Integer, Queue<Integer>> userTimestamps = new HashMap<>();
        int[] res = new int[user.length];

        for (int i = 0; i < user.length; i++) {
            int u = user[i];
            int t = timestamp[i];
            userTimestamps.putIfAbsent(u, new LinkedList<>());
            Queue<Integer> times = userTimestamps.get(u);

            // Remove timestamps outside the 60-second window
            while (!times.isEmpty() && times.peek() < t - 59) {
                times.poll();
            }

            if (times.size() < k) {
                res[i] = 1; // Request allowed
                times.offer(t);
            } else {
                res[i] = 0; // Request denied
            }
        }
        return res;
    }
}
