// Question 88
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ComputationCost {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] computationCap = new long[n];
        for(int i = 0; i < n; i++) {
            computationCap[i] = scanner.nextLong();
        }
        
        long[] cost = new long[n];
        for(int i = 0; i < n; i++) {
            cost[i] = scanner.nextLong();
        }
        
        long avgCap = scanner.nextLong();
        long maxCap = scanner.nextLong();
        
        long targetTotalCap = avgCap * n;
        long currentTotalCap = 0;
        for(long cap : computationCap) {
            currentTotalCap += cap;
        }

        if (currentTotalCap >= targetTotalCap) {
            System.out.println(0);
            scanner.close();
            return;
        }

        long neededIncrease = targetTotalCap - currentTotalCap;
        
        List<long[]> servers = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            long max_inc = maxCap - computationCap[i];
            if(max_inc > 0) {
                servers.add(new long[]{cost[i], max_inc});
            }
        }

        servers.sort(Comparator.comparingLong(a -> a[0]));
        
        long totalCost = 0;
        for(long[] s : servers) {
            long costOfServer = s[0];
            long maxIncreaseForServer = s[1];
            
            long increaseAmount = Math.min(neededIncrease, maxIncreaseForServer);
            
            totalCost += increaseAmount * costOfServer;
            neededIncrease -= increaseAmount;
            
            if(neededIncrease == 0) {
                break;
            }
        }

        if(neededIncrease > 0) {
            System.out.println(-1);
        } else {
            System.out.println(totalCost);
        }
        
        scanner.close();
    }
}