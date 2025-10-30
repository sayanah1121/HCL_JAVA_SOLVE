// Question 15
import java.util.Scanner;

public class PeakAPILoadWindow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int window = scanner.nextInt();
        int n = scanner.nextInt();
        int[] timestamps = new int[n];
        for (int i = 0; i < n; i++) {
            timestamps[i] = scanner.nextInt();
        }
        int left = 0;
        int maxCount = 0;
        for (int right = 0; right < n; right++) {
            while (left <= right && timestamps[right] - timestamps[left] >= window) {
                left++;
            }
            int count = right - left + 1;
            if (count > maxCount) {
                maxCount = count;
            }
        }
        System.out.println(maxCount);
        scanner.close();
    }
}