// Question 37
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class InteractionPairRetrieval {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] services = new int[n];
        for (int i = 0; i < n; i++) {
            services[i] = scanner.nextInt();
        }
        long k = scanner.nextLong();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int s : services) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
        }
        List<Integer> vals = new ArrayList<>(freq.keySet());
        Collections.sort(vals);
        Map<Integer, Integer> sjCount = new HashMap<>();
        for (int s : services) {
            sjCount.put(s, sjCount.getOrDefault(s, 0) + 1);
        }
        List<Integer> distinctSj = new ArrayList<>(sjCount.keySet());
        Collections.sort(distinctSj);
        for (int val : vals) {
            long num = (long) n * freq.get(val);
            if (k <= num) {
                for (int sj : distinctSj) {
                    long cnt = freq.get(val);
                    if (k <= cnt) {
                        System.out.println(val);
                        System.out.println(sj);
                        scanner.close();
                        return;
                    }
                    k -= cnt;
                }
            }
            k -= num;
        }
        scanner.close();
    }
}