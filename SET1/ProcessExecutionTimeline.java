// Question 20
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProcessExecutionTimeline {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] start = new int[n];
        for (int i = 0; i < n; i++) start[i] = sc.nextInt();
        sc.nextInt(); // another n
        int[] end = new int[n];
        for (int i = 0; i < n; i++) end[i] = sc.nextInt();
        
        // create list of intervals
        List<int[]> intervals = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            intervals.add(new int[]{start[i], end[i]});
        }
        
        // sort by start
        intervals.sort(Comparator.comparingInt(a -> a[0]));
        
        // merge
        List<int[]> merged = new ArrayList<>();
        for (int[] interval : intervals) {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        }
        
        // calculate total time
        long total = 0;
        for (int[] m : merged) {
            total += (long) m[1] - m[0] + 1;
        }
        System.out.println(total);
        sc.close();
    }
}