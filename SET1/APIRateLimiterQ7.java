// Question 7
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class APIRateLimiterQ7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Number of requests
        int n = scanner.nextInt();
        int[] user = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) user[i] = scanner.nextInt();
        for (int i = 0; i < n; i++) time[i] = scanner.nextInt();
        int k = scanner.nextInt();
        int t = scanner.nextInt();

        int[] result = getAllowedRequests(user, time, k, t);
        for (int i : result) {
            System.out.println(i);
        }
        scanner.close();
    }

    static int[] getAllowedRequests(int[] user, int[] time, int k, int t) {
        Map<Integer, Deque<Integer>> userRequestTimes = new HashMap<>();
        int[] allowed = new int[user.length];

        for (int i = 0; i < user.length; i++) {
            int u = user[i], currTime = time[i];
            userRequestTimes.putIfAbsent(u, new ArrayDeque<>());
            Deque<Integer> times = userRequestTimes.get(u);

            // Remove timestamps outside the sliding window [currTime - t + 1, currTime]
            while (!times.isEmpty() && times.peekFirst() < currTime - t + 1) {
                times.pollFirst();
            }

            if (times.size() < k) {
                allowed[i] = 1;
                times.offerLast(currTime);
            } else {
                allowed[i] = 0;
            }
        }
        return allowed;
    }
}
