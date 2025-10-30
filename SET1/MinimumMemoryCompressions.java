// Question 31
import java.util.Scanner;

public class MinimumMemoryCompressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] memoryBlocks = new int[n];
        for (int i = 0; i < n; i++) {
            memoryBlocks[i] = scanner.nextInt();
        }
        int[] freq = new int[1000001];
        for (int size : memoryBlocks) {
            if (size <= 1000000) {
                freq[size]++;
            }
        }
        int carry = 0;
        int operations = 0;
        for (int i = 0; i <= 1000000; i++) {
            int total = freq[i] + carry;
            operations += total % 2;
            carry = total / 2;
        }
        while (carry > 0) {
            operations += carry % 2;
            carry /= 2;
        }
        System.out.println(operations);
        scanner.close();
    }
}