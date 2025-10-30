// Question 19
import java.util.Arrays;
import java.util.Scanner;

public class FindMissingLogWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] timestamp = new int[n];
        for (int i = 0; i < n; i++) timestamp[i] = scanner.nextInt();
        int windowSize = scanner.nextInt();
        Arrays.sort(timestamp);
        int current = 1;
        for (int i = 0; i < n; i++) {
            if (timestamp[i] > current) {
                int gap = timestamp[i] - current;
                if (gap >= windowSize) {
                    System.out.println(current);
                    scanner.close();
                    return;
                }
            }
            current = timestamp[i] + 1;
        }
        // after last, infinite gap
        System.out.println(current);
        scanner.close();
    }
}