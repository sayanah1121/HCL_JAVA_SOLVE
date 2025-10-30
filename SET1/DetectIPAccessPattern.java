//Question 6
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DetectIPAccessPattern {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] ip = new int[n];
        for (int i = 0; i < n; i++) {
            ip[i] = scanner.nextInt();
        }
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) {
            timestamp[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        int t = scanner.nextInt();

        List<Integer> result = getSpammerIPs(ip, timestamp, k, t);
        for (int val : result) {
            System.out.println(val);
        }
        scanner.close();
    }

    public static List<Integer> getSpammerIPs(int[] ip, int[] timestamp, int k, int t) {
        Map<Integer, List<Integer>> ipAccessMap = new HashMap<>();
        int n = ip.length;

        for (int i = 0; i < n; i++) {
            ipAccessMap.computeIfAbsent(ip[i], _ -> new ArrayList<>()).add(timestamp[i]);
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
