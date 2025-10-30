// Question 42
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SortBugFrequencies {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Integer[] bugs = new Integer[n];
        for (int i = 0; i < n; i++) bugs[i] = scanner.nextInt();
        Map<Integer, Integer> freq = new HashMap<>();
        for (int b : bugs) freq.put(b, freq.getOrDefault(b, 0) + 1);
        Arrays.sort(bugs, (a, b) -> {
            int fa = freq.get(a), fb = freq.get(b);
            if (fa != fb) return Integer.compare(fa, fb);
            return Integer.compare(a, b);
        });
        for (int b : bugs) System.out.println(b);
        scanner.close();
    }
}