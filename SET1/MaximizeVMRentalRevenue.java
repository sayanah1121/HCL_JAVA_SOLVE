// Question 48
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximizeVMRentalRevenue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            int stock = scanner.nextInt();
            pq.add(stock);
        }
        int m = scanner.nextInt();
        long revenue = 0;
        for (int i = 0; i < m; i++) {
            int maxStock = pq.poll();
            revenue += maxStock;
            if (maxStock > 1) {
                pq.add(maxStock - 1);
            }
        }
        System.out.println(revenue);
        scanner.close();
    }
}