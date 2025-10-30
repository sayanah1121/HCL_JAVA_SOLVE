// Question 50
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MinimizeURLCompression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        int k = scanner.nextInt();
        Set<Character> unique = new HashSet<>();
        for (char c : url.toCharArray()) {
            unique.add(c);
        }
        int d = unique.size();
        int minCompression = k - Math.min(k, d);
        System.out.println(minCompression);
        scanner.close();
    }
}