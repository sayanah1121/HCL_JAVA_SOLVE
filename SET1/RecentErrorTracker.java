// Question 17
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RecentErrorTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int t = sc.nextInt();
        int n = sc.nextInt();
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) timestamps[i] = sc.nextInt();
        sc.nextInt(); // another n
        String[] errorCodes = new String[n];
        for (int i = 0; i < n; i++) errorCodes[i] = sc.next();
        
        // find max timestamp
        int maxT = timestamps[n - 1];
        int startTime = maxT - t;
        
        // find the smallest index where timestamps[i] >= startTime
        int startIdx = 0;
        for (int i = 0; i < n; i++) {
            if (timestamps[i] >= startTime) {
                startIdx = i;
                break;
            }
        }
        
        // count frequencies from startIdx to n-1
        Map<String, Integer> count = new HashMap<>();
        for (int i = startIdx; i < n; i++) {
            count.put(errorCodes[i], count.getOrDefault(errorCodes[i], 0) + 1);
        }
        
        // collect those >= k
        List<String> result = new ArrayList<>();
        for (String code : count.keySet()) {
            if (count.get(code) >= k) {
                result.add(code);
            }
        }
        
        // sort
        Collections.sort(result);
        
        // output
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();
        }
        sc.close();
    }
}