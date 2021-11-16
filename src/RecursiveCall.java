public class RecursiveCall {
    // Recursive call that calling the method itself from inside a method for logical conciseness
    public static void main(String[] args) {
        System.out.println(factorial(5)); // 120
    }
    // Factorial : n!
    // f(n) = n * f(n - 1), f(1) = 1
    // 5! = 5 * 4 * 3 * 2 * 1
    static int factorial (int num) {
        int result = 0;
        if (num == 1) {
            result = 1;
        } else {
            result = num * factorial(num - 1);
        }
        return result;
    }
}
