// Q7
import java.util.*;

public class APIRateLimiterQ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of requests
        int n = sc.nextInt();
        int[] user = new int[n];
        int[] time = new int[n];
        for (int i = 0; i < n; i++) user[i] = sc.nextInt();
        for (int i = 0; i < n; i++) time[i] = sc.nextInt();
        int k = sc.nextInt();
        int t = sc.nextInt();

        int[] result = getAllowedRequests(user, time, k, t);
        for (int i : result) {
            System.out.println(i);
        }
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
