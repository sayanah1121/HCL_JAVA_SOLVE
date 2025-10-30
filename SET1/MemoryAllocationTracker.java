// Question 25
import java.util.*;

public class MemoryAllocationTracker {

    public static int getMaxOverlapTime(int[] start, int[] end) {
        // Create list of all events (time, +1 for start, -1 for end+1)
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            events.add(new int[]{start[i], +1});
            events.add(new int[]{end[i] + 1, -1});
        }
        // Sort events by time asc
        events.sort(Comparator.comparingInt(a -> a[0]));

        int active = 0;
        int maxActive = 0;
        int earliestTimeOfMax = Integer.MAX_VALUE;

        for (int[] event : events) {
            active += event[1];
            if (active > maxActive) {
                maxActive = active;
                // The max active count start at this event time
                earliestTimeOfMax = event[0];
            }
        }

        // earliest time should be within original intervals, so subtract 1 if event is an end+1
        return earliestTimeOfMax == Integer.MAX_VALUE ? -1 : earliestTimeOfMax;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] start = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] end = new int[m];
        for (int i = 0; i < m; i++) {
            end[i] = scanner.nextInt();
        }

        int result = getMaxOverlapTime(start, end);
        System.out.println(result);

        scanner.close();
    }
}
