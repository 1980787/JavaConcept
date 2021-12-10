import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class StringIntro {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String A =sc.next(); // hello
        String B =sc.next(); // java
        /* Enter your code here. Print output to STDOUT. */
//        printStringSum(A, B); // 9
//        lexicographical(A, B); // No
//        replacePrint(A, B); // Hello Java

//        printStringSumLength.accept(A, B);
//        lexicographicalBiConsumer.accept(A, B);
//        replacePrintBiConsumer.accept(A, B);

//        System.out.println(printStringSumLengthBiFunction.apply(A, B));
//        System.out.println(lexicographicalBiFunction.apply(A, B));
//        System.out.println(replacePrintBiFunction.apply(A, B));
    }
    static void printStringSum (String a, String b) {
        System.out.println(a.length() + b.length());
    }
    static void lexicographical(String a, String b) {
        System.out.println(a.charAt(0) > b.charAt(0) ? "Yes" : "No");
    }
    static void replacePrint(String a, String b) {
        // toUpperCase()
        // Stream.concat(str1, str2).forEach(System.out::print);
        System.out.println(Character.toUpperCase(a.charAt(0)) + a.substring(1)
                + " " + Character.toUpperCase(b.charAt(0)) + b.substring(1));
    }

    // java.lang.Runnable    void run() that no param, no return
    // Supplier                 T get() no param, return
    // Consumer        void accept(T t) param, no return
    // BiConsumer void accept(T t, U u) two param, no return
    static BiConsumer<String, String> printStringSumLength = (a, b) -> System.out.println(a.length() + b.length());
    static BiConsumer<String, String> lexicographicalBiConsumer = (a, b) -> System.out.println(a.charAt(0) > b.charAt(0) ? "Yes" : "No");
    static BiConsumer<String, String> replacePrintBiConsumer = (a, b) -> System.out.println(Character.toUpperCase(a.charAt(0)) + a.substring(1)
            + " " + Character.toUpperCase(b.charAt(0)) + b.substring(1));

    // Function            R apply(T t) one param, return
    // BiFunction    R apply (T t, U u) two param, return
    static BiFunction<String, String, String> printStringSumLengthBiFunction = (a, b) -> String.valueOf(a.length() + b.length());
    static BiFunction<String, String, String> lexicographicalBiFunction = (a, b) -> a.charAt(0) > b.charAt(0) ? "Yes" : "No";
    static BiFunction<String, String, String> replacePrintBiFunction = (a, b) -> Character.toUpperCase(a.charAt(0)) + a.substring(1)
            + " " + Character.toUpperCase(b.charAt(0)) + b.substring(1);
}
