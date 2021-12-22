import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();

            //Write your code here
            boolean isValid = false;
            // (...) group
            // . any character except new line (\n)
            // + 1 or more, * 0 or more
            // [^abc] Not a or b or c
            // \1 matches whatever was matched in the 1st group of parentheses, which in this case is the (.+)
            String regex = "<(.+)>([^<>]+)</\\1>";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(line);
            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                System.out.println(m.group(2));
                isValid = true;
            }
            if (! isValid) {
                System.out.println("None");
            }
            /*
            4
            <h1>Nayeem loves counseling</h1>
            Nayeem loves counseling
            <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
            Sanjay has no watch
            So wait for a while
            <Amee>safat codes like a ninja</amee>
            None
            <SA premium>Imtiaz has a secret crush</SA premium>
            Imtiaz has a secret crush
             */
            testCases--;
        }
    }
}
