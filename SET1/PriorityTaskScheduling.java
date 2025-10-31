// Question 81
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PriorityTaskScheduling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] operations = new int[m][2];
        for (int i = 0; i < m; i++) {
            operations[i][0] = scanner.nextInt();
            operations[i][1] = scanner.nextInt();
        }
        // process
        List<Long> results = new ArrayList<>();
        long global_time = 0;
        List<Long> addTimes = new ArrayList<>();
        for (int[] op : operations) {
            if (op[0] == 1) {
                // add task
                addTimes.add(global_time);
            } else if (op[0] == 2) {
                // wait
                global_time += op[1];
            } else if (op[0] == 3) {
                // execute
                long threshold = (long) op[1] - global_time;
                int idx = findFirstGE(addTimes, threshold);
                int count = addTimes.size() - idx;
                results.add((long) count);
                // remove
                addTimes.subList(idx, addTimes.size()).clear();
            }
        }
        // output
        for (long res : results) {
            System.out.println(res);
        }
        scanner.close();
    }

    static int findFirstGE(List<Long> list, long val) {
        int low = 0, high = list.size();
        while (low < high) {
            int mid = (low + high) / 2;
            if (list.get(mid) >= val) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}