import java.util.*;

class passwordAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("HAVE DOUBTS ANALYZE YOUR PASSWORD HERE JUST DROP IT");
        String p = sc.nextLine();

        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String digits = "0123456789";
        String specialChars = "!@#$%^&*()_+-=~`{}[]|\\:;\"'<>,.?/";
        boolean upper = false, lower = false, digit = false, special = false;

        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            if (Character.isUpperCase(ch))
                upper = true;
            else if (Character.isLowerCase(ch))
                lower = true;
            else if (Character.isDigit(ch))
                digit = true;
            else if (specialChars.indexOf(ch) >= 0)
                special = true;
        }

        StringBuilder newPassword = new StringBuilder(p);
        Random random = new Random();
        if (!upper)
            newPassword.append(uppercase.charAt(random.nextInt(uppercase.length())));
        if (!lower)
            newPassword.append(lowercase.charAt(random.nextInt(lowercase.length())));
        if (!digit)
            newPassword.append(digits.charAt(random.nextInt(digits.length())));
        if (!special)
            newPassword.append(specialChars.charAt(random.nextInt(specialChars.length())));

        System.out.println("Suggested password: " + newPassword);
    }
}