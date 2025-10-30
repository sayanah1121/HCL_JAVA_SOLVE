// Question 14

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SessionReconstructor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int timeout = scanner.nextInt();
        int n = scanner.nextInt();
        String[] userIds = new String[n];
        for (int i = 0; i < n; i++) {
            userIds[i] = scanner.next();
        }
        scanner.nextInt(); // read n again
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }
        // Now process
        Map<String, List<Integer>> userEvents = new HashMap<>();
        for (int i = 0; i < n; i++) {
            userEvents.computeIfAbsent(userIds[i], _ -> new ArrayList<>()).add(timestamps[i]);
        }
        int totalSessions = 0;
        for (List<Integer> times : userEvents.values()) {
            Collections.sort(times);
            int sessions = 1; // at least one session
            for (int i = 1; i < times.size(); i++) {
                if (times.get(i) - times.get(i-1) > timeout) {
                    sessions++;
                }
            }
            totalSessions += sessions;
        }
        System.out.println(totalSessions);
        scanner.close();
    }
}