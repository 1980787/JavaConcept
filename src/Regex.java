import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class Regex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String IP = in.next();
            // Pattern.compile(regex).matchder(input).matches()
            //                    return boolean
            System.out.println(IP.matches(new MyRegex().pattern));
            /*
            000.12.12.034
            true
            121.234.12.12
            true
            23.45.12.56
            true
            00.12.123.123123.123
            false
            122.23
            false
            Hello.IP
            false
             */
        }
    }

}
// IP address is a string in the form "A.B.C.D", where the value of A, B, C, and D may range from 0 to 255.
// Leading zeros are allowed. The length of A, B, C, or D can't be greater than 3.
// Some valid IP address:
// 000.12.12.034
// 121.234.12.12
// 23.45.12.56

// Some invalid IP address:
// 000.12.234.23.23
// 666.666.23.23
// .213.123.23.32
// 23.45.22.32.
// I.Am.not.an.ip
class MyRegex {
    // ranges or regex
    // \\d         == [0-9]           : 0-9
    // \\d\\d      == [0-9][0-9]      : 10 - 99
    // (a|b) : a or b
    // (0|1)\\d\\d == (0|1)[0-9][0-9] : 099 - 199
    // 2[0-4]\\d   == 2[0-4][0-9]     : 200 - 249
    // 25[0-5]                        : 250 - 255
    String pattern = "(\\d|\\d\\d|(0|1)\\d\\d|2[0-4]\\d|25[0-5])." +
                    "(\\d|\\d\\d|(0|1)\\d\\d|2[0-4]\\d|25[0-5])." +
                    "(\\d|\\d\\d|(0|1)\\d\\d|2[0-4]\\d|25[0-5])." +
                    "(\\d|\\d\\d|(0|1)\\d\\d|2[0-4]\\d|25[0-5])";
}


