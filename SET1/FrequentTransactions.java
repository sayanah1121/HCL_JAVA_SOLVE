// Q 53

import java.util.*;

public class FrequentTransactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of transactions
        int n = sc.nextInt();
        int[] transactions = new int[n];
        
        // Read transaction amounts
        for (int i = 0; i < n; i++) {
            transactions[i] = sc.nextInt();
        }
        
        // Get sorted transactions and print
        int[] result = sortTransactions(transactions);
        for (int value : result) {
            System.out.println(value);
        }
        
        sc.close();
    }
    
    public static int[] sortTransactions(int[] transactions) {
        // Create a list of pairs (frequency, amount) for sorting
        List<int[]> pairs = new ArrayList<>();
        
        // Calculate frequency of each transaction amount
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int amount : transactions) {
            frequencyMap.put(amount, frequencyMap.getOrDefault(amount, 0) + 1);
        }
        
        // Create pairs for sorting: [frequency, amount, original_amount]
        for (int amount : transactions) {
            int freq = frequencyMap.get(amount);
            pairs.add(new int[]{freq, amount, amount});
        }
        
        // Sort first by frequency (ascending), then by amount (ascending)
        pairs.sort((a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0]; // Sort by frequency ascending
            } else {
                return a[1] - b[1]; // Sort by amount ascending if frequencies are equal
            }
        });
        
        // Extract the sorted amounts
        int[] result = new int[transactions.length];
        for (int i = 0; i < pairs.size(); i++) {
            result[i] = pairs.get(i)[2]; // original amount
        }
        
        return result;
    }
}
