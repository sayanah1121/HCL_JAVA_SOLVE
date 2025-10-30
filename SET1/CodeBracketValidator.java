// Question - 22
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class CodeBracketValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String s = scanner.nextLine();
            System.out.println(isValid(s) ? "YES" : "NO");
        }
        scanner.close();
    }

    private static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                    (c == '}' && top != '{') ||
                    (c == ']' && top != '[')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
