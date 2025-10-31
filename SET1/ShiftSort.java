// Question 76
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ShiftSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[n];
        Set<Long> set = new HashSet<>();
        boolean distinct = true;
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextLong();
            if (!set.add(arr[i])) distinct = false;
        }
        if (!distinct) {
            System.out.println(-1);
        } else {
            int count = 0;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) count++;
            }
            System.out.println(count);
        }
        scanner.close();
    }
}