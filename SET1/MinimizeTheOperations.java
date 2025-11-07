// Question 98
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimizeTheOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            set.add(x);
        }
        int k = sc.nextInt();
        int distinct = set.size();
        int ans = Math.max(1, distinct - k);
        System.out.println(ans);
        sc.close();
    }
}