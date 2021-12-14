import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SubstringComparisons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
        /*
        welcometojava
        3
        ava
        wel
         */
        System.out.println(getSmallestAndLargest(s, k));
    }
    // Lexicographical Order, also known as alphabetic or dictionary order, orders characters as follows:
    // A < B < ... < Y < Z < a < b < ... < y < z
    // For example, ball < cat, dog < dorm, Happy < happy, Zoo < ball
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        ArrayList<String> stringList = new ArrayList<>();
        for (int i = 0; i <= s.length() - k; i++) {
            stringList.add(s.substring(i, i + k));
        }
        Collections.sort(stringList);
//        System.out.println(stringList); // [ava, com, elc, eto, jav, lco, met, oja, ome, toj, wel]
        smallest = stringList.get(0);
        largest = stringList.get(stringList.size() -1);

        // java 8
//        IntStream intStream = s.chars();
//        Stream<Character> characterSteam = s.chars().mapToObj(c -> (char) c);
        Stream<String> stringStream = s.codePoints().mapToObj(c -> String.valueOf((char) c));
//        stringStream.forEach(System.out::println); // welcometojava
        stringStream.map(p -> p.substring(0, k)).forEach(System.out::println);
        //.iterate(0, i -> i + k).limit(s.length() - k);

        return smallest + "\n" + largest;
    }
}
