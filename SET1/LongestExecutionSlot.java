//  Q 57
import java.util.Scanner;

public class LongestExecutionSlot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of log entries
        int n = scanner.nextInt();
        // The second integer (number of columns) is always 2, so we can skip it
        scanner.nextInt(); 

        int[][] runLogs = new int[n][2];
        for (int i = 0; i < n; i++) {
            runLogs[i][0] = scanner.nextInt();
            runLogs[i][1] = scanner.nextInt();
        }
        scanner.close();

        // Find the character ID of the process with the longest run
        char result = findLongestRun(runLogs);
        System.out.println(result);
    }

    public static char findLongestRun(int[][] runLogs) {
        int longestDuration = 0;
        int longestRunProcessID = -1;
        int previousEndTime = 0;

        for (int[] log : runLogs) {
            int currentProcessID = log[0];
            int currentEndTime = log[1];

            // Calculate the duration of the current run
            int duration = currentEndTime - previousEndTime;

            // Check if this run is the new longest
            if (duration > longestDuration) {
                longestDuration = duration;
                longestRunProcessID = currentProcessID;
            }

            // The end time of this run becomes the start time for the next
            previousEndTime = currentEndTime;
        }

        // Convert the process ID (0-25) to its character representation ('a'-'z')
        return (char) ('a' + longestRunProcessID);
    }
}
