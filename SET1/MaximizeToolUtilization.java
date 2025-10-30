// Question 58
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximizeToolUtilization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(scanner.nextLine());
            pq.add(val);
        }
        int m = Integer.parseInt(scanner.nextLine());
        long sum = 0;
        for (int i = 0; i < m; i++) {
            int val = pq.poll();
            sum += val;
            pq.add(val - 1);
        }
        System.out.println(sum);
        scanner.close();
    }
}