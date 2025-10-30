// Question 49
import java.util.Scanner;
import java.util.TreeMap;

public class MinimizeDecompressionSteps {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int operations = 0;

        while (true) {
            // Find the largest even number
            Integer largestEven = null;
            for (Integer key : map.descendingKeySet()) {
                if (key % 2 == 0) {
                    largestEven = key;
                    break;
                }
            }
            if (largestEven == null) break;
            int count = map.get(largestEven);
            int newVal = largestEven / 2;
            map.put(newVal, map.getOrDefault(newVal, 0) + count);
            map.remove(largestEven);
            operations++;
        }
        System.out.println(operations);
        scanner.close();
    }
}