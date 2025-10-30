// Question 9
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemLoadMonitor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of load entries
        int n = scanner.nextInt();
        int[] loads = new int[n];

        // Read each load value
        for (int i = 0; i < n; i++) {
            loads[i] = scanner.nextInt();
        }

        // Read window size and threshold
        int windowSize = scanner.nextInt();
        int threshold = scanner.nextInt();

        scanner.close();

        // Get the list of high-load minutes
        List<Integer> highLoadMinutes = detectHighLoadWindows(loads, windowSize, threshold);

        // Print the results
        for (int minute : highLoadMinutes) {
            System.out.println(minute);
        }
    }

    public static List<Integer> detectHighLoadWindows(int[] loads, int windowSize, int threshold) {
        List<Integer> highLoadMinutes = new ArrayList<>();
        if (loads.length < windowSize) {
            return highLoadMinutes; // Not enough data for a full window
        }

        double currentSum = 0;

        // Calculate sum for the first window
        for (int i = 0; i < windowSize; i++) {
            currentSum += loads[i];
        }

        // Check the first window
        if ((currentSum / windowSize) > threshold) {
            highLoadMinutes.add(windowSize - 1);
        }

        // Slide the window across the rest of the array
        for (int i = windowSize; i < loads.length; i++) {
            currentSum = currentSum - loads[i - windowSize] + loads[i];
            if ((currentSum / windowSize) > threshold) {
                highLoadMinutes.add(i);
            }
        }

        return highLoadMinutes;
    }
}
