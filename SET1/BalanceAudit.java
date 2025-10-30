// Question 36
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BalanceAudit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextInt(); // always 3
        Map<String, Long> balance = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String sender = scanner.next();
            String receiver = scanner.next();
            int amount = Integer.parseInt(scanner.next());
            balance.put(sender, balance.getOrDefault(sender, 0L) - amount);
            balance.put(receiver, balance.getOrDefault(receiver, 0L) + amount);
        }
        long minBalance = Long.MAX_VALUE;
        for (long val : balance.values()) {
            if (val < minBalance) {
                minBalance = val;
            }
        }
        if (minBalance >= 0) {
            System.out.println("Nobody has a negative balance");
        } else {
            List<String> result = new ArrayList<>();
            for (Map.Entry<String, Long> entry : balance.entrySet()) {
                if (entry.getValue() == minBalance) {
                    result.add(entry.getKey());
                }
            }
            Collections.sort(result);
            for (String name : result) {
                System.out.println(name);
            }
        }
        scanner.close();
    }
}