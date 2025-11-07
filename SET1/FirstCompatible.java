// Question 94

import java.util.*;

public class FirstCompatible {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        long[] arr1 = new long[n];
        for(int i = 0; i < n; i++) {
            arr1[i] = scanner.nextLong();
        }
        
        int m = scanner.nextInt();
        long[] arr2 = new long[m];
        for(int i = 0; i < m; i++) {
            arr2[i] = scanner.nextLong();
        }
        
        List<long[]> list = new ArrayList<>();
        for(int j = 0; j < m; j++) {
            list.add(new long[]{arr2[j], j});
        }
        
        Collections.sort(list, (a, b) -> {
            if (a[0] != b[0]) return Long.compare(a[0], b[0]);
            return Long.compare(a[1], b[1]);
        });
        
        for(int i = 0; i < n; i++) {
            // binary search for first > arr1[i]
            int low = 0, high = m;
            while(low < high) {
                int mid = (low + high) / 2;
                if(list.get(mid)[0] <= arr1[i]) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            if(low < m) {
                System.out.println((int)list.get(low)[1] + 1);
            } else {
                System.out.println(-1);
            }
        }
        
        scanner.close();
    }
}