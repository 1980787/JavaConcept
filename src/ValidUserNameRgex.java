import java.util.Scanner;

public class ValidUserNameRgex {
    private static final Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();
            /*
            8
            Julia
            Invalid
            Samantha
            Valid
            Samantha_21
            Valid
            1Samantha
            Invalid
            Samantha?10_2A
            Invalid
            JuliaZ007
            Valid
            Julia@007
            Invalid
            _Julia007
            Invalid
             */
            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    // ^ : Start of string, or start of line in multi-line pattern
    // [a-z] : Lower case letter from a to z
    // [A-Z] : Upper case letter from A to Z
    // \\w : matches any alphanumeric or num or _ character. == [A-Za-z0-9_]
    // {7, 29} : 7, 8, 9, .. , 28, 29
    // $ : End of string, or end of line in multi-line pattern
    public static final String regularExpression = "^[a-zA-Z]\\w{7,29}$";
}