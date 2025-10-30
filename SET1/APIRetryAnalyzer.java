// Question 13

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class APIRetryAnalyzer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gap = scanner.nextInt();
        int n = scanner.nextInt();
        String[] requestIds = new String[n];
        for (int i = 0; i < n; i++) {
            requestIds[i] = scanner.next();
        }
        scanner.nextInt(); // n again
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(requestIds[i])) {
                map.put(requestIds[i], new ArrayList<>());
            }
            map.get(requestIds[i]).add(timestamps[i]);
        }
        int total = 0;
        for (List<Integer> list : map.values()) {
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i + 1) - list.get(i) <= gap) {
                    total++;
                }
            }
        }
        System.out.println(total);
        scanner.close();
    }
}