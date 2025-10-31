// Question 69
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryClassification {
    public static int getOptimalClassification(int[] scores, String labels) {
        int n = scores.length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new int[]{scores[i], labels.charAt(i) - '0'});
        }
        list.sort((a, b) -> Integer.compare(a[0], b[0]));
        List<long[]> groups = new ArrayList<>();
        int i = 0;
        while (i < n) {
            int j = i;
            int S = list.get(i)[0];
            long g0 = 0, g1 = 0;
            while (j < n && list.get(j)[0] == S) {
                if (list.get(j)[1] == 0) g0++;
                else g1++;
                j++;
            }
            groups.add(new long[]{S, g0, g1});
            i = j;
        }
        long total0 = 0, total1 = 0;
        for (long[] g : groups) {
            total0 += g[1];
            total1 += g[2];
        }
        long maxCorrect = total0;
        maxCorrect = Math.max(maxCorrect, total1);
        long current0 = 0;
        long current1 = total1;
        for (long[] g : groups) {
            long correct = current0 + current1;
            maxCorrect = Math.max(maxCorrect, correct);
            correct = current0 + g[1] + (current1 - g[2]);
            maxCorrect = Math.max(maxCorrect, correct);
            current0 += g[1];
            current1 -= g[2];
        }
        return (int) maxCorrect;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] scores = new int[n];
        for (int i = 0; i < n; i++) scores[i] = scanner.nextInt();
        String labels = scanner.next();
        System.out.println(getOptimalClassification(scores, labels));
        scanner.close();
    }
}