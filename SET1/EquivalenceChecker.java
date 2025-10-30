// Question 38
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class EquivalenceChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] sourceNames = new String[n];
        for (int i = 0; i < n; i++) {
            sourceNames[i] = scanner.next();
        }
        String[] targetNames = new String[n];
        for (int i = 0; i < n; i++) {
            targetNames[i] = scanner.next();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(checkEquivalence(sourceNames[i], targetNames[i]));
        }
        scanner.close();
    }

    private static String checkEquivalence(String s, String t) {
        if (s.equals(t)) return "YES";
        List<Integer> diff = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t.charAt(i)) {
                diff.add(i);
            }
        }
        if (diff.isEmpty()) return "YES";
        // check operation on s
        Set<Character> sChars = new HashSet<>();
        Set<Character> tChars = new HashSet<>();
        for (int idx : diff) {
            sChars.add(s.charAt(idx));
            tChars.add(t.charAt(idx));
        }
        if (sChars.size() == 1 && tChars.size() == 1) return "YES";
        // check operation on t
        sChars.clear();
        tChars.clear();
        for (int idx : diff) {
            sChars.add(t.charAt(idx));
            tChars.add(s.charAt(idx));
        }
        if (sChars.size() == 1 && tChars.size() == 1) return "YES";
        return "NO";
    }
}