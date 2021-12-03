import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class LambdaExpressions {
    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T--> 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = ob.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = ob.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = ob.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
            /*
            5
            1 4
            EVEN
            2 5
            PRIME
            3 898
            PALINDROME
            1 3
            ODD
            2 12
            COMPOSITE
             */
        }
    }
}

interface PerformOperation {
    boolean check(int a);
}
class MyMath {
    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }
    // Write your code here
    public static PerformOperation isOdd() {
        return num -> (num % 2 != 0);
    }
    public static PerformOperation isPrime() {
        return num -> (num > 1 && IntStream.range(2, num).noneMatch(i -> num % i == 0));
    }
    // dad, 12021,
    public static PerformOperation isPalindrome() {
        return num -> IntStream.iterate(num, a -> a / 10).limit(11).filter(i -> i > 0).map(b -> b % 10).reduce(0, (c,d) -> c * 10 + d) == num;
    }

}