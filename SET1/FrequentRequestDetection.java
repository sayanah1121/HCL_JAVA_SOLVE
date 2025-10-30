// Question 24
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequentRequestDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] requestIDs = new String[n];
        for (int i = 0; i < n; i++) requestIDs[i] = scanner.nextLine();
        int n2 = Integer.parseInt(scanner.nextLine()); // should be n
        int[] timestamps = new int[n2];
        for (int i = 0; i < n2; i++) timestamps[i] = Integer.parseInt(scanner.nextLine());
        int timeWindow = Integer.parseInt(scanner.nextLine());
        System.out.println(countFrequentRequestIDs(requestIDs, timestamps, timeWindow));
        scanner.close();
    }

    private static int countFrequentRequestIDs(String[] requestIDs, int[] timestamps, int timeWindow) {
        Map<String, List<Integer>> map = new HashMap<>();
        int n = requestIDs.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(requestIDs[i], _ -> new ArrayList<>()).add(timestamps[i]);
        }
        int count = 0;
        for (List<Integer> times : map.values()) {
            Collections.sort(times);
            for (int i = 1; i < times.size(); i++) {
                if (times.get(i) - times.get(i - 1) <= timeWindow) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
