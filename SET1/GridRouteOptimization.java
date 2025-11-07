// Question 96
import java.util.Scanner;

public class GridRouteOptimization {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String directions = sc.nextLine();
        int startX = sc.nextInt();
        int startY = sc.nextInt();
        int endX = sc.nextInt();
        int endY = sc.nextInt();
        int n = directions.length();
        long dx = (long) endX - startX;
        long dy = (long) endY - startY;
        int[] countE = new int[n + 1];
        int[] countW = new int[n + 1];
        int[] countN = new int[n + 1];
        int[] countS = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            countE[i] = countE[i - 1];
            countW[i] = countW[i - 1];
            countN[i] = countN[i - 1];
            countS[i] = countS[i - 1];
            char c = directions.charAt(i - 1);
            if (c == 'E') countE[i]++;
            else if (c == 'W') countW[i]++;
            else if (c == 'N') countN[i]++;
            else if (c == 'S') countS[i]++;
        }
        int left = 1, right = n;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long e = countE[mid];
            long w = countW[mid];
            long nn = countN[mid];
            long ss = countS[mid];
            long lowx = Math.max(0, -dx);
            long highx = Math.min(w, e - dx);
            boolean possiblex = lowx <= highx;
            long min_ab = possiblex ? 2 * lowx + dx : Long.MAX_VALUE;
            long lowy = Math.max(0, -dy);
            long highy = Math.min(ss, nn - dy);
            boolean possibley = lowy <= highy;
            long min_cd = possibley ? 2 * lowy + dy : Long.MAX_VALUE;
            if (possiblex && possibley && min_ab + min_cd <= mid) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
