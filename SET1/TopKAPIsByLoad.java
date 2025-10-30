//Q4
import java.util.*;

public class TopKAPIsByLoad {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of API calls
        int n = sc.nextInt();
        int[] apiIndex = new int[n];
        for (int i = 0; i < n; i++) {
            apiIndex[i] = sc.nextInt();
        }
        int[] loads = new int[n];
        for (int i = 0; i < n; i++) {
            loads[i] = sc.nextInt();
        }
        int k = sc.nextInt();

        int[] result = getTopKAPIs(apiIndex, loads, k);
        for (int idx : result)
            System.out.println(idx);
    }

    public static int[] getTopKAPIs(int[] apiIndex, int[] loads, int k) {
        Map<Integer, Integer> loadMap = new HashMap<>();
        for (int i = 0; i < apiIndex.length; i++) {
            loadMap.put(apiIndex[i], loadMap.getOrDefault(apiIndex[i], 0) + loads[i]);
        }

        List<Map.Entry<Integer, Integer>> apiList = new ArrayList<>(loadMap.entrySet());
        apiList.sort((a, b) -> {
            if (b.getValue() != a.getValue())
                return b.getValue() - a.getValue(); // Descending by load
            else
                return a.getKey() - b.getKey(); // Ascending by index
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = apiList.get(i).getKey();
        }
        return ans;
    }
}
