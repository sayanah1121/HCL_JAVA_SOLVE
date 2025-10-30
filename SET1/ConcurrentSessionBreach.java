import java.util.*;

public class ConcurrentSessionBreach {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Read number of events
        int n = sc.nextInt();
        int[] timestamps = new int[n];
        String[] userIds = new String[n];
        String[] actions = new String[n];

        // Read timestamps
        for (int i = 0; i < n; i++) {
            timestamps[i] = sc.nextInt();
        }
        // Read userIds
        for (int i = 0; i < n; i++) {
            userIds[i] = sc.next();
        }
        // Read actions
        for (int i = 0; i < n; i++) {
            actions[i] = sc.next();
        }
        // Read session limit
        int m = sc.nextInt();

        List<String> result = getLimitBreaches(timestamps, userIds, actions, m);

        // Output
        for (String user : result) {
            System.out.println(user);
        }
    }

    public static List<String> getLimitBreaches(int[] timestamps, String[] userIds, String[] actions, int m) {
        Map<String, Integer> sessionCount = new HashMap<>();
        Set<String> breached = new HashSet<>();

        for (int i = 0; i < timestamps.length; i++) {
            String user = userIds[i];
            String action = actions[i];

            sessionCount.putIfAbsent(user, 0);

            if (action.equals("login")) {
                sessionCount.put(user, sessionCount.get(user) + 1);
            } else if (action.equals("logout")) {
                sessionCount.put(user, Math.max(0, sessionCount.get(user) - 1));
            }

            if (sessionCount.get(user) > m) {
                breached.add(user);
            }
        }

        List<String> breachedUsers = new ArrayList<>(breached);
        Collections.sort(breachedUsers);
        return breachedUsers;
    }
}
