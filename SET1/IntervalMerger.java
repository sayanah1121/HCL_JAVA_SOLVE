// Question 11

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class IntervalMerger {

    public static List<Integer> getMergedIntervalStarts(int[] startTime, int[] endTime) {
        int n = startTime.length;
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new int[]{startTime[i], endTime[i]});
        }
        // Sort intervals by start time
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        
        List<Integer> starts = new ArrayList<>();
        int[] current = intervals.get(0);
        starts.add(current[0]);
        
        for (int i = 1; i < n; i++) {
            int[] next = intervals.get(i);
            if (next[0] <= current[1]) {
                // Overlap, merge
                current[1] = Math.max(current[1], next[1]);
            } else {
                // New interval
                starts.add(next[0]);
                current = next;
            }
        }
        return starts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] startTime = new int[n];
        int[] endTime = new int[n];
        for (int i = 0; i < n; i++) {
            startTime[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            endTime[i] = scanner.nextInt();
        }
        List<Integer> result = getMergedIntervalStarts(startTime, endTime);
        System.out.println(result);
        scanner.close();
    }
}