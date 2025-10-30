import java.util.*;

public class ConcurrentEventCounter {
    public static int getMaxOverlap(int[] start, int[] end) {
        List<int[]> events = new ArrayList<>();
        
        for (int s : start) {
            events.add(new int[]{s, 1});
        }
        
        for (int e : end) {
            events.add(new int[]{e + 1, -1});
        }
        
        Collections.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        int maxOverlap = 0;
        int currentOverlap = 0;
        
        for (int[] event : events) {
            currentOverlap += event[1];
            maxOverlap = Math.max(maxOverlap, currentOverlap);
        }
        
        return maxOverlap;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    
        int n = scanner.nextInt();
        
        int[] start = new int[n];
        int[] end = new int[n];
        
        for (int i = 0; i < n; i++) {
            start[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            end[i] = scanner.nextInt();
        }
        
        int maxOverlap = getMaxOverlap(start, end);
        System.out.println("Maximum overlapping events: " + maxOverlap);
        
        scanner.close();
    }
}
