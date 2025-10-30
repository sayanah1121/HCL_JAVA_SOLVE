// Question 45
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimizingTaskResourceConsumption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
        }
        long total = 0;
        while (!list.isEmpty()) {
            int minIndex = 0;
            for (int i = 1; i < list.size(); i++) {
                if (list.get(i) < list.get(minIndex)) {
                    minIndex = i;
                }
            }
            total += list.get(minIndex);
            // Remove minIndex and adjacent
            List<Integer> newList = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i != minIndex && i != minIndex - 1 && i != minIndex + 1) {
                    newList.add(list.get(i));
                }
            }
            list = newList;
        }
        System.out.println(total);
        scanner.close();
    }
}