// Question 61
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class RetrieveMissingLabel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] labels = new long[n];
        for (int i = 0; i < n; i++) {
            labels[i] = scanner.nextLong();
        }
        long k = scanner.nextLong();
        
        Arrays.sort(labels);
        // remove duplicates
        List<Long> unique = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || labels[i] != labels[i - 1]) {
                unique.add(labels[i]);
            }
        }
        long[] sorted = unique.stream().mapToLong(Long::longValue).toArray();
        
        long low = 1;
        long high = 1000000000000000L; // 1e15
        while (low < high) {
            long mid = low + (high - low) / 2;
            // count how many <= mid
            int count = upperBound(sorted, mid);
            long missing = mid - count;
            if (missing >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(low);
        scanner.close();
    }
    
    static int upperBound(long[] arr, long val) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}