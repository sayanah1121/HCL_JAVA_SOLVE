// Question 41
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ClosestAPILatencySpikes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] latencies = new int[n];
        for (int i = 0; i < n; i++) {
            latencies[i] = scanner.nextInt();
        }
        Arrays.sort(latencies);
        int minDiff = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            minDiff = Math.min(minDiff, latencies[i] - latencies[i - 1]);
        }
        List<int[]> pairs = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (latencies[i] - latencies[i - 1] == minDiff) {
                pairs.add(new int[]{latencies[i - 1], latencies[i]});
            }
        }
        // pairs are already in order since array is sorted
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }
        scanner.close();
    }
}