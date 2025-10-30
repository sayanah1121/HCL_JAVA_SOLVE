//Q6
import java.util.*;

public class DetectIPAccessPattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] ip = new int[n];
        for (int i = 0; i < n; i++) {
            ip[i] = sc.nextInt();
        }
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int t = sc.nextInt();

        List<Integer> result = getSpammerIPs(ip, timestamp, k, t);
        for (int val : result) {
            System.out.println(val);
        }
    }

    public static List<Integer> getSpammerIPs(int[] ip, int[] timestamp, int k, int t) {
        Map<Integer, List<Integer>> ipAccessMap = new HashMap<>();
        int n = ip.length;

        for (int i = 0; i < n; i++) {
            ipAccessMap.computeIfAbsent(ip[i], x -> new ArrayList<>()).add(timestamp[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, List<Integer>> entry : ipAccessMap.entrySet()) {
            List<Integer> times = entry.getValue();
            Collections.sort(times);

            // Sliding window to check if more than k accesses in any t second window
            int start = 0;
            boolean spammerFound = false;
            for (int end = 0; end < times.size(); end++) {
                while (times.get(end) - times.get(start) > t) {
                    start++;
                }
                if (end - start + 1 > k) {
                    spammerFound = true;
                    break;
                }
            }
            if (spammerFound) {
                result.add(entry.getKey());
            }
        }
        Collections.sort(result);
        return result;
    }
}
