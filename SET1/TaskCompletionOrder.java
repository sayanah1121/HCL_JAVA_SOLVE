// Question 65
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskCompletionOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] time = new long[n];
        for (int i = 0; i < n; i++) time[i] = scanner.nextLong();
        long m = scanner.nextLong();
        ArrayDeque<long[]> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) queue.add(new long[]{i + 1, time[i]});
        List<Long> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            long[] front = queue.peek();
            if (front[1] <= m) {
                order.add(front[0]);
                queue.poll();
            } else {
                front[1] -= m;
                queue.poll();
                queue.add(front);
            }
        }
        for (int i = 0; i < order.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(order.get(i));
        }
        System.out.println();
        scanner.close();
    }
}