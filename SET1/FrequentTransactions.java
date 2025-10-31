// Question 53

import java.util.Scanner;

public class FrequentTransactions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of transactions
        int n = scanner.nextInt();
        int[] transactions = new int[n];
        
        // Read transaction amounts
        for (int i = 0; i < n; i++) {
            transactions[i] = scanner.nextInt();
        }
        
        // Get sorted transactions and print
        int[] result = sortTransactions(transactions);
        for (int value : result) {
            System.out.println(value);
        }
        
        scanner.close();
    }
    
    public static int[] sortTransactions(int[] transactions) {
        int n = transactions.length;
        int[] frequencies = new int[n];

        // Step 1: Calculate frequency of each transaction.
        // For each transaction, iterate through the entire list to count its occurrences.
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (transactions[i] == transactions[j]) {
                    count++;
                }
            }
            frequencies[i] = count;
        }

        // Step 2: Sort the transactions using a bubble sort algorithm.
        // The sorting is based on frequency first, then by amount.
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Condition for swapping:
                // 1. If frequency of the current element is greater than the next.
                // 2. Or if frequencies are equal, but the current element's amount is greater than the next.
                if (frequencies[j] > frequencies[j + 1] || (frequencies[j] == frequencies[j + 1] && transactions[j] > transactions[j + 1])) {
                    // Swap frequencies
                    int tempFreq = frequencies[j];
                    frequencies[j] = frequencies[j + 1];
                    frequencies[j + 1] = tempFreq;

                    // Swap transaction amounts
                    int tempAmount = transactions[j];
                    transactions[j] = transactions[j + 1];
                    transactions[j + 1] = tempAmount;
                }
            }
        }
        
        // Step 3: Return the sorted transactions array.
        return transactions;
    }
}
