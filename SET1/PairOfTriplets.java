// Question 82
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PairOfTriplets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        // process
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        for (int i = 0; i <= n - 3; i++) {
            int a = arr[i], b = arr[i + 1], c = arr[i + 2];
            String key1 = b + " " + c;
            map1.put(key1, map1.getOrDefault(key1, 0) + 1);
            String key2 = a + " " + c;
            map2.put(key2, map2.getOrDefault(key2, 0) + 1);
            String key3 = a + " " + b;
            map3.put(key3, map3.getOrDefault(key3, 0) + 1);
        }
        long ans = 0;
        for (int freq : map1.values()) {
            if (freq >= 2) ans += (long) freq * (freq - 1) / 2;
        }
        for (int freq : map2.values()) {
            if (freq >= 2) ans += (long) freq * (freq - 1) / 2;
        }
        for (int freq : map3.values()) {
            if (freq >= 2) ans += (long) freq * (freq - 1) / 2;
        }
        System.out.println(ans);
        scanner.close();
    }
}