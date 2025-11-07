// Question 93

import java.util.Scanner;

public class OptimizeTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String s = scanner.nextLine();
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (i <= s.length() - 3 && s.charAt(i) == '1') {
                sb.append("100");
                i += 3;
            } else {
                sb.append(s.charAt(i));
                i++;
            }
        }
        
        System.out.println(sb.toString());
        
        scanner.close();
    }
}