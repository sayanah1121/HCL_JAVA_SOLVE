// Question 67
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ArrayRangeMinimization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) arr1[i] = scanner.nextLong();
        long[] arr2 = new long[n];
        for (int i = 0; i < n; i++) arr2[i] = scanner.nextLong();
        List<long[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new long[]{arr1[i], i});
            list.add(new long[]{arr2[i], i});
        }
        Collections.sort(list, Comparator.comparingLong(a -> a[0]));
        int[] freq = new int[n];
        int count = 0;
        long min_diff = Long.MAX_VALUE;
        int left = 0;
        for (int right = 0; right < 2 * n; right++) {
            int idx = (int) list.get(right)[1];
            freq[idx]++;
            if (freq[idx] == 1) count++;
            while (count == n && left <= right) {
                long diff = list.get(right)[0] - list.get(left)[0];
                if (diff < min_diff) min_diff = diff;
                int lidx = (int) list.get(left)[1];
                freq[lidx]--;
                if (freq[lidx] == 0) count--;
                left++;
            }
        }
        System.out.println(min_diff);
        scanner.close();
    }
}