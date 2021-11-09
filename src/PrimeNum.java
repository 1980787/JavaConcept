public class PrimeNum {
    public static void main(String[] args) {
        int testNum1 = 11;
        if (isPrime(testNum1)) {
            System.out.println(testNum1 + " is a prime number.");
        } else {
            System.out.println(testNum1 + " is not a prime number.");
        }

    }
    // convert java 8+
    // using stream
    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }


}
