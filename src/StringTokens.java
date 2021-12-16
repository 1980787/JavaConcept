import java.util.Arrays;
import java.util.Scanner;

public class StringTokens {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); // He is a very very good boy, isn't he?
        String s = scan.nextLine();
        // Write your code here.
        s = s.trim();
        if(s.length() == 0 || s.length() > 400000) {
            System.out.println(0);
        } else {
            System.out.println(s.split("[ !,?._'@]+").length);
            for (String str : s.split("[ !,?._'@]+")) {
                System.out.println(str);
            }
        }
        scan.close();
    }
}
