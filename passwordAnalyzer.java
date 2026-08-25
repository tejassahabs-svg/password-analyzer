import java.util.Scanner;

public class PasswordAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================================");
        System.out.println("   HAVE DOUBTS? ANALYZE YOUR PASSWORD   ");
        System.out.println("=========================================");
        
        System.out.print("Enter password: ");
        String p = sc.nextLine();
        int l = p.length();
        int score = 0;

        // 1. FEATURE: Length Analyzer Check
        if (l >= 8) {
            System.out.println("-> Length Check: Pass (8+ characters)");
            score += 2;
        } else {
            System.out.println("-> Length Check: Fail (Too short)");
        }

        // 2. FEATURE: High-Fidelity Character Zones Check
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>/?";

        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        // Class 11 Loop Structure
        for (int i = 0; i < l; i++) {
            char ch = p.charAt(i);
            if (uppercase.indexOf(ch) != -1) hasUpper = true;
            else if (lowercase.indexOf(ch) != -1) hasLower = true;
            else if (digits.indexOf(ch) != -1) hasDigit = true;
            else if (specialChars.indexOf(ch) != -1) hasSpecial = true;
        }

        // Score Calculation
        if (hasUpper) score += 1;
        if (hasDigit) score += 1;
        if (hasSpecial) score += 1;

        System.out.println("-> Upper Case check: " + (hasUpper ? "Pass" : "Fail"));
        System.out.println("-> Digits check: " + (hasDigit ? "Pass" : "Fail"));
        System.out.println("-> Special Symbols check: " + (hasSpecial ? "Pass" : "Fail"));

        // 3. FEATURE: Password Suggestor (Runs if score is weak)
        if (score < 5) {
            System.out.println("\n[System Suggestion]: Your password could be stronger.");
            StringBuilder newPassword = new StringBuilder(p);
            if (!hasUpper) newPassword.append("X");
            if (!hasDigit) newPassword.append("7");
            if (!hasSpecial) newPassword.append("@");
            System.out.println("Suggested Upgrade: " + newPassword.toString());
        }

        // 4. Final Output Metrics
        System.out.println("\n-----------------------------------------");
        System.out.println("FINAL SECURITY SCORE: " + score + "/5");
        System.out.println("=========================================");
        
        sc.close();
    }
}