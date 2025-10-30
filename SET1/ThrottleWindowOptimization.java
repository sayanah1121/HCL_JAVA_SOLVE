// Question 47
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThrottleWindowOptimization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> responseTimes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            responseTimes.add(scanner.nextInt());
        }
        long totalSum = 0;
        while (!responseTimes.isEmpty()) {
            // Find the index of the minimum value
            int minIndex = 0;
            for (int i = 1; i < responseTimes.size(); i++) {
                if (responseTimes.get(i) < responseTimes.get(minIndex)) {
                    minIndex = i;
                }
            }
            // Add the minimum value to the sum
            totalSum += responseTimes.get(minIndex);
            // Remove the minIndex and its adjacent elements
            int start = Math.max(0, minIndex - 1);
            int end = Math.min(responseTimes.size() - 1, minIndex + 1);
            // Remove from end to start to avoid index issues
            for (int i = end; i >= start; i--) {
                responseTimes.remove(i);
            }
        }
        System.out.println(totalSum);
        scanner.close();
    }
}