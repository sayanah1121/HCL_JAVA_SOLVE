// Question 62
import java.util.Scanner;

public class APIGatewayLogging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] jobs = new int[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = scanner.nextInt();
        }
        int[] gateways = new int[n];
        for (int i = 0; i < n; i++) {
            gateways[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        long[] load = new long[m + 1];
        for (int i = 0; i < n; i++) {
            int g = gateways[i];
            load[g] += (long) jobs[i] + 1;
        }
        for (int i = 1; i <= m; i++) {
            if (i > 1) System.out.print(" ");
            System.out.print(load[i]);
        }
        System.out.println();
        scanner.close();
    }
}