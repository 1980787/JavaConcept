import java.util.Scanner;
import java.util.regex.Pattern;

public class SyntaxChecker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String pattern = in.nextLine();
            //Write your code
            try {
                Pattern.compile(pattern);
                System.out.println("Valid");
            } catch (Exception e) { // handle invalid pattern
                System.out.println("Invalid");
            }
            testCases--;
        }
        /*
        3
        ([A-Z])(.+)
        Valid
        [AZ[a-z](a-z)
        Invalid
        batcatpat(nat
        Invalid
         */
    }
}
