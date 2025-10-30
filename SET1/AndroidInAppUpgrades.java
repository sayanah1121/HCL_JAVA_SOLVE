// Question 46
import java.util.Scanner;

public class AndroidInAppUpgrades {
    static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] upgradeCosts = new int[n];
        for (int i = 0; i < n; i++) upgradeCosts[i] = scanner.nextInt();
        int budget = scanner.nextInt();
        // 0/1 Knapsack DP
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int cost = upgradeCosts[i];
            int value = 1 << i;
            for (int j = budget; j >= cost; j--) {
                dp[j] = Math.max(dp[j], (dp[j - cost] + value) % MOD);
            }
        }
        int maxEnhance = 0;
        for (int v : dp) maxEnhance = Math.max(maxEnhance, v);
        System.out.println(maxEnhance % MOD);
        scanner.close();
    }
}
