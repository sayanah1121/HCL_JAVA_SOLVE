// Question 2
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServerDowntimeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the size of startTime array
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
        }
        // Read the size of endTime array
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            endTime[i] = scanner.nextInt();
        }
        // Total monitoring time
        int t = scanner.nextInt();

        // Find total downtime and print
        System.out.println(getTotalDowntime(startTime, endTime, t));
        scanner.close();
    }

    // Helper method to compute downtime
    public static int getTotalDowntime(int[] startTime, int[] endTime, int t) {
        int n = startTime.length;
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new int[] {startTime[i], endTime[i]});
        }
        // Sort intervals by start time
        intervals.sort((a, b) -> a[0] - b[0]);

        // Merge intervals
        List<int[]> merged = new ArrayList<>();
        for (int[] curr : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < curr[0] - 1) {
                merged.add(curr);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], curr[1]);
            }
        }

        // Calculate uptime sum
        int uptime = 0;
        for (int[] interval : merged) {
            uptime += interval[1] - interval[0] + 1;
        }
        // Downtime is total time - uptime
        return t - uptime;
    }
}
