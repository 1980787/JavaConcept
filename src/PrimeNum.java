import java.util.stream.IntStream;

public class PrimeNum {
    public static void main(String[] args) {
        int testNum1 = 7853;
        if (isPrime(testNum1)) {
            System.out.println(testNum1 + " is a prime number.");
        } else {
            System.out.println(testNum1 + " is not a prime number.");
        }

    }
    // convert java 8+
    // using stream
    static boolean isPrime(int num) {
        // Java 7
//        if (num <= 1) {
//            return false;
//        }
//        for (int i = 2; i < num; i++) {
//            if (num % i == 0) {
//                return false;
//            }
//        }
//        return true;
        // Java 8
        return num > 1 && IntStream.range(2, num).noneMatch(i -> num % i == 0);
    }


}
