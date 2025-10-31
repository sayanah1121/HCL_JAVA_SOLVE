// Question 75
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SumPairs {
    static class FenwickTree {
        long[] tree;
        int n;
        FenwickTree(int n) {
            this.n = n;
            tree = new long[n + 1];
        }
        void update(int idx, long val) {
            while (idx <= n) {
                tree[idx] += val;
                idx += idx & -idx;
            }
        }
        long query(int idx) {
            long sum = 0;
            while (idx > 0) {
                sum += tree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
        long query(int l, int r) {
            return query(r) - query(l - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
        }
        long lowerLimit = scanner.nextLong();
        long upperLimit = scanner.nextLong();

        // Get unique values and frequencies
        Map<Long, Integer> freq = new HashMap<>();
        for (long val : arr) {
            freq.put(val, freq.getOrDefault(val, 0) + 1);
        }
        List<Long> sortedUnique = new ArrayList<>(freq.keySet());
        Collections.sort(sortedUnique);
        int rankSize = sortedUnique.size();
        Map<Long, Integer> rank = new HashMap<>();
        for (int i = 0; i < rankSize; i++) {
            rank.put(sortedUnique.get(i), i + 1);
        }

        // Build Fenwick Tree
        FenwickTree ft = new FenwickTree(rankSize);
        for (long val : sortedUnique) {
            ft.update(rank.get(val), freq.get(val));
        }

        long count = 0;
        for (long val : arr) {
            long L = lowerLimit - val;
            long R = upperLimit - val;
            // Find left: smallest index where sortedUnique.get(idx) >= L
            int left = lowerBound(sortedUnique, L);
            // Find right: largest index where sortedUnique.get(idx) <= R
            int right = upperBound(sortedUnique, R);
            if (left <= right) {
                count += ft.query(left + 1, right + 1); // ranks are 1-based
            }
        }
        System.out.println(count);
        scanner.close();
    }

    static int lowerBound(List<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) < val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    static int upperBound(List<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) <= val) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low - 1;
    }
}