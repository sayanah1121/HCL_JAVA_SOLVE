// Q 56
import java.util.*;

public class EfficientDroneDescent {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read grid dimensions (always 4x4)
        int n = scanner.nextInt();  // rows (should be 4)
        int m = scanner.nextInt();  // columns (should be 4)
        
        // Read the 4x4 grid
        int[][] city = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                city[i][j] = scanner.nextInt();
            }
        }
        
        scanner.close();
        
        // Calculate maximum power remaining
        int result = maxPower(city);
        System.out.println(result);
    }
    
    public static int maxPower(int[][] city) {
        int rows = city.length;
        int cols = city[0].length;
        
        // dp[i][j] = maximum power remaining when reaching cell (i,j)
        int[][] dp = new int[rows][cols];
        
        // Initialize first row - start from any position with initial power 100
        for (int j = 0; j < cols; j++) {
            dp[0][j] = 100 - city[0][j];
        }
        
        // Fill DP table for subsequent rows
        for (int i = 1; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int maxPowerFromPrev = Integer.MIN_VALUE;
                
                // Check all possible previous positions (j-1, j, j+1)
                for (int prevJ = Math.max(0, j - 1); prevJ <= Math.min(cols - 1, j + 1); prevJ++) {
                    maxPowerFromPrev = Math.max(maxPowerFromPrev, dp[i-1][prevJ]);
                }
                
                // Update current cell power
                dp[i][j] = maxPowerFromPrev - city[i][j];
            }
        }
        
        // Find maximum power in the last row
        int maxPowerRemaining = Integer.MIN_VALUE;
        for (int j = 0; j < cols; j++) {
            maxPowerRemaining = Math.max(maxPowerRemaining, dp[rows-1][j]);
        }
        
        return maxPowerRemaining;
    }
}
