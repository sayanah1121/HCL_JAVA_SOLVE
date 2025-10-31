// Question 84
import java.util.Scanner;

public class ValidBinaryTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count0 = 0, count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') count0++;
            else count1++;
        }
        int opt1 = count1; // all 0s
        int opt2 = count0; // all 1s
        int opt3 = (s.charAt(0) == '0' ? 1 : 0); // 1 then 0s
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') opt3++;
        }
        int opt4 = (s.charAt(0) == '1' ? 1 : 0); // 0 then 1s
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0') opt4++;
        }
        int ans = Math.min(Math.min(opt1, opt2), Math.min(opt3, opt4));
        System.out.println(ans);
        sc.close();
    }
}