//Question 10

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// A helper class to hold timestamp and load pairs
class DataPoint {
    int timestamp;
    int load;

    DataPoint(int timestamp, int load) {
        this.timestamp = timestamp;
        this.load = load;
    }
}

public class ServerLoadSnapshot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of data entries
        int n = scanner.nextInt();
        int[] timestamps = new int[n];
        int[] loads = new int[n];

        // Read all timestamps
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }

        // Read all loads
        for (int i = 0; i < n; i++) {
            loads[i] = scanner.nextInt();
        }

        // Read the window size
        int windowSize = scanner.nextInt();
        scanner.close();

        // Calculate and print the max load
        long maxLoad = findMaxLoadInWindow(timestamps, loads, windowSize);
        System.out.println(maxLoad);
    }

    public static long findMaxLoadInWindow(int[] timestamps, int[] loads, int windowSize) {
        int n = timestamps.length;
        if (n == 0) {
            return 0;
        }

        // Create a list of DataPoint objects to sort by timestamp
        List<DataPoint> dataPoints = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            dataPoints.add(new DataPoint(timestamps[i], loads[i]));
        }

        // Sort the data points based on their timestamp
        Collections.sort(dataPoints, Comparator.comparingInt(dp -> dp.timestamp));

        long maxLoad = 0;
        long currentLoad = 0;
        int start = 0;

        // Use a sliding window to find the maximum load
        for (int end = 0; end < n; end++) {
            // Add the current element's load to the window sum
            currentLoad += dataPoints.get(end).load;

            // Shrink the window from the left if its time span exceeds the windowSize
            while (dataPoints.get(end).timestamp - dataPoints.get(start).timestamp >= windowSize) {
                currentLoad -= dataPoints.get(start).load;
                start++;
            }

            // Update the maximum load seen so far
            maxLoad = Math.max(maxLoad, currentLoad);
        }

        return maxLoad;
    }
}
