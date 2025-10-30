// Question 39
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaximumOnes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int k = scanner.nextInt();
        int n = s.length();
        int originalOnes = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') originalOnes++;
        }
        List<Integer> distances = new ArrayList<>();
        int lastOne = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                lastOne = i;
            } else {
                if (lastOne != -1) {
                    distances.add(lastOne - i);
                }
            }
        }
        Collections.sort(distances);
        int canTurn = Math.min(k, distances.size());
        int maxOnes = originalOnes + canTurn;
        System.out.println(maxOnes);
        scanner.close();
    }
}