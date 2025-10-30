// Question 8
import java.util.Scanner;

public class AnomalySpikeIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] metrics = new int[n];
        for (int i = 0; i < n; i++) {
            metrics[i] = scanner.nextInt();
        }

        System.out.println(detectFirstAnomaly(metrics));
        scanner.close();
    }

    public static int detectFirstAnomaly(int[] metrics) {
        if (metrics.length == 0) return -1;
        int maxVal = metrics[0];
        for (int i = 1; i < metrics.length; i++) {
            if (metrics[i] >= 3 * maxVal) {
                return i;
            }
            if (metrics[i] > maxVal) {
                maxVal = metrics[i];
            }
        }
        return -1;
    }
}
