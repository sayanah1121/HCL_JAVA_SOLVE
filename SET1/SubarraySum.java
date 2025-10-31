// Question 90
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SubarraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr1 = new long[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextLong();
        }
        int m = sc.nextInt();
        List<Long> positive = new ArrayList<>();
        List<Long> negative = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            long val = sc.nextLong();
            if (val >= 0) {
                positive.add(val);
            } else {
                negative.add(val);
            }
        }
        Collections.sort(positive, Collections.reverseOrder());
        Collections.sort(negative);
        long[] left = positive.stream().mapToLong(Long::longValue).toArray();
        long[] right = negative.stream().mapToLong(Long::longValue).toArray();
        
        long maxOriginal = kadane(arr1);
        long maxLeftSuffix = left.length == 0 ? Long.MIN_VALUE : maxSuffixSum(left);
        long maxRightPrefix = right.length == 0 ? Long.MIN_VALUE : maxPrefixSum(right);
        
        long[] prefixOriginal = new long[n];
        if (n > 0) {
            prefixOriginal[0] = arr1[0];
            for (int j = 1; j < n; j++) {
                prefixOriginal[j] = prefixOriginal[j - 1] + arr1[j];
            }
        }
        long[] suffixOriginal = new long[n];
        if (n > 0) {
            suffixOriginal[n - 1] = arr1[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                suffixOriginal[i] = suffixOriginal[i + 1] + arr1[i];
            }
        }
        
        long ans = maxOriginal;
        if (maxLeftSuffix != Long.MIN_VALUE) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, prefixOriginal[j] + maxLeftSuffix);
            }
        }
        if (maxRightPrefix != Long.MIN_VALUE) {
            for (int i = 0; i < n; i++) {
                ans = Math.max(ans, suffixOriginal[i] + maxRightPrefix);
            }
        }
        long maxLeft = kadane(left);
        long maxRight = kadane(right);
        ans = Math.max(ans, maxLeft);
        ans = Math.max(ans, maxRight);
        System.out.println(ans);
        sc.close();
    }
    
    static long kadane(long[] a) {
        if (a.length == 0) return Long.MIN_VALUE / 2; // to avoid overflow issues
        long max = a[0], cur = a[0];
        for (int i = 1; i < a.length; i++) {
            cur = Math.max(a[i], cur + a[i]);
            max = Math.max(max, cur);
        }
        return max;
    }
    
    static long maxSuffixSum(long[] a) {
        long max = a[a.length - 1];
        long sum = a[a.length - 1];
        for (int i = a.length - 2; i >= 0; i--) {
            sum += a[i];
            max = Math.max(max, sum);
        }
        return max;
    }
    
    static long maxPrefixSum(long[] a) {
        long max = a[0];
        long sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum += a[i];
            max = Math.max(max, sum);
        }
        return max;
    }
}