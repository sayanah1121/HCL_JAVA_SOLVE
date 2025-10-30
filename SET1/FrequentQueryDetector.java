// Question 16
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FrequentQueryDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int threshold = scanner.nextInt();
        int n = scanner.nextInt();
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }
        String[] queryTypes = new String[n];
        for (int i = 0; i < n; i++) {
            queryTypes[i] = scanner.next();
        }
        // process
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(queryTypes[i], new ArrayList<>());
            map.get(queryTypes[i]).add(timestamps[i]);
        }
        List<String> result = new ArrayList<>();
        for (String qt : map.keySet()) {
            List<Integer> times = map.get(qt);
            Collections.sort(times);
            int max = 0;
            int j = 0;
            for (int i = 0; i < times.size(); i++) {
                while (j < times.size() && times.get(j) - times.get(i) <= 600) {
                    j++;
                }
                max = Math.max(max, j - i);
            }
            if (max >= threshold) {
                result.add(qt);
            }
        }
        Collections.sort(result);
        for (String s : result) {
            System.out.println(s);
        }
        scanner.close();
    }
}