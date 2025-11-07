// Question 125

import java.util.Scanner;

public class TokenValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the tokenString
        String tokenString = scanner.nextLine();
        
        // Split by space
        String[] tokens = tokenString.split(" ");
        
        int count = 0;
        for (String token : tokens) {
            if (isValid(token)) {
                count++;
            }
        }
        
        // Output
        System.out.println(count);
        
        scanner.close();
    }
    
    private static boolean isValid(String token) {
        if (token.length() < 3) return false;
        
        boolean hasVowel = false;
        boolean hasConsonant = false;
        
        for (char c : token.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            
            char lower = Character.toLowerCase(c);
            if (Character.isLetter(lower)) {
                if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                    hasVowel = true;
                } else {
                    hasConsonant = true;
                }
            }
        }
        
        return hasVowel && hasConsonant;
    }
}