// Question 18
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadSpikeDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] load = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            load[i] = scanner.nextInt();
            sum += load[i];
        }
        double avg = (double) sum / n;
        double threshold = 2 * avg;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (load[i] > threshold) {
                result.add(i);
            }
        }
        if (!result.isEmpty()) {
            for (int i = 0; i < result.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(result.get(i));
            }
            System.out.println();
        }
        scanner.close();
    }
}