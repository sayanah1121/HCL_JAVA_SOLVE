// Question 40
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ArraySplit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int[] prefixDistinct = new int[n];
        Set<Integer> seen = new HashSet<>();
        for (int i = 0; i < n; i++) {
            seen.add(arr[i]);
            prefixDistinct[i] = seen.size();
        }

        int[] suffixDistinct = new int[n];
        seen.clear();
        for (int i = n - 1; i >= 0; i--) {
            seen.add(arr[i]);
            suffixDistinct[i] = seen.size();
        }

        int max_sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int current_sum = prefixDistinct[i] + suffixDistinct[i + 1];
            if (current_sum > max_sum) {
                max_sum = current_sum;
            }
        }

        System.out.println(max_sum);
        scanner.close();
    }
}