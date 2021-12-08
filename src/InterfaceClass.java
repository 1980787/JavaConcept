import java.util.Scanner;
import java.util.stream.IntStream;
// A Java interface can only contain method signatures and fields.
// The interface can be used to achieve polymorphism.
public class InterfaceClass {
    public static void main(String[] args) {
        MyCalculator my_calculator = new MyCalculator();
        System.out.print("I implemented: ");
        ImplementedInterfaceNames(my_calculator);
        System.out.print("Enter any number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(my_calculator.divisor_sum(n) + "\n");
        sc.close();
    }
    /*
     *  ImplementedInterfaceNames method takes an object and prints the name of the interfaces it implemented
     */
    static void ImplementedInterfaceNames(Object o){
        Class[] theInterfaces = o.getClass().getInterfaces();
        for (int i = 0; i < theInterfaces.length; i++){
            String interfaceName = theInterfaces[i].getName();
            System.out.println(interfaceName);
        }
    }
}

class MyCalculator implements AdvancedArithmetic {
    @Override
    public int divisor_sum(int n) {
        // java 7
//        int sum = 0;
//        for (int i = 1; i <= n; i++) {
//            if (n % i == 0) {
//                sum += i;
//            }
//        }
//        return sum;

        // java 8+
         return IntStream.rangeClosed(1, n).filter(i -> n % i == 0).sum();
    }
}

interface AdvancedArithmetic{
    int divisor_sum(int n);
}