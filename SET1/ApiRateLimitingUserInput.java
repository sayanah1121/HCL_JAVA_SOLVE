// Question 27

import java.util.*;

public class ApiRateLimitingUserInput {

    public static int calculateSchedulingTime(int[] capacity, long requests) {
        // Max-heap to pick server with maximum capacity
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int cap : capacity) {
            maxHeap.offer(cap);
        }

        int seconds = 0;

        while (requests > 0 && !maxHeap.isEmpty()) {
            int maxCap = maxHeap.poll();  // highest capacity server
            requests -= maxCap;           // handle requests
            seconds++;                    // one second used

            int reducedCap = maxCap / 2;  // halve the capacity
            if (reducedCap > 0) {
                maxHeap.offer(reducedCap);
            }
        }

        return seconds;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // take number of servers
        int n = sc.nextInt();

        int[] capacity = new int[n];
        for (int i = 0; i < n; i++) {
            capacity[i] = sc.nextInt();
        }

        // take number of requests
        long requests = sc.nextLong();

        int result = calculateSchedulingTime(capacity, requests);
        System.out.println("Minimum seconds required: " + result);
    }
}
