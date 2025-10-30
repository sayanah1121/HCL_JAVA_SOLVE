// Question 23
import java.util.*;

public class SuspiciousLoginPairs {

    public static long countSuspiciousPairs(int[] timestamps, int timeWindow) {
        Arrays.sort(timestamps);
        long count = 0;
        int n = timestamps.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            // Move j forward while timestamps[j] - timestamps[i] <= timeWindow
            while (j < n && timestamps[j] - timestamps[i] <= timeWindow) {
                j++;
            }
            // All indices between i+1 and j-1 form suspicious pairs with i
            count += (j - i - 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] timestamps = new int[n];

        for (int i = 0; i < n; i++) {
            timestamps[i] = sc.nextInt();
        }
        int timeWindow = sc.nextInt();

        long result = countSuspiciousPairs(timestamps, timeWindow);
        System.out.println(result);
        sc.close();
    }
}
