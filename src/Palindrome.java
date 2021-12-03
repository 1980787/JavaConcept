import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Palindrome {
    public static void main(String[] args) {
        String str = "abcba";
//        System.out.println(str.length()/2);
//        System.out.println(isPalindrome(str));

        int num = 1221;
        System.out.println(isNumPalindrome(num));
    }
    static boolean isNumPalindrome(int num) {
        // int
        // Java < 8
//        int origin = num;
//        int reverse = 0;
//        while (num > 0) {
//            int remainder = num % 10;
//            reverse = reverse * 10 + remainder;
//            num /= 10;
//        }
//        return origin == reverse;

        // java 8+
        // intermediate operations that iterate(), map(),limit(), filter()
            // iterate(startNum, formula) that starting from startNum, infinitely generate results calculated by formula
            // Stream.iterate(0, n -> n+2); // 0, 2, 4, 6, ...
            // map() that convert an object to something else.
            // Stream.map(n -> n * 2);
//          IntStream.rangeClosed(1, 4).map(n -> n*2).forEach(System.out::println); // 2468
        // terminal operation reduce() that calculate by decreasing the elements of stream one by one
            // reduce(initial value, function for combining two values)
            // Stream.reduce(0, (a, b) -> a + b)
    //        System.out.println(IntStream.rangeClosed(1, 4).reduce(0, (a, b) -> a + b)); // 10 = 1 + 2 + 3 + 4
        // int length: 11
        return IntStream.iterate(num, a -> a / 10).limit(11).filter(i -> i > 0).map(b -> b % 10).reduce(0, (c,d) -> c * 10 + d) == num;
    }

    static boolean isPalindrome(String words) {
        // two pointer
        // String
        // Java < 8
//        int start = 0;
//        int end = words.length() -1;
//        boolean result = false;

//        if (words.length() == 1) {
//            return true;
//        }
//        while (start < end) {
//            if (words.charAt(start) == words.charAt(end)) {
//                result = true;
//            } else {
//                result = false;
//            }
//            start++;
//            end--;
//        }
//        return result;

        // Java 8+                              for loop                    if statement
        return words.length() >= 1 && IntStream.range(0, words.length() /2).allMatch(i -> words.charAt(i) == words.charAt(words.length() - 1 - i));

    }

}
