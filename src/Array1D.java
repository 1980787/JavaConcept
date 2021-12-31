import java.util.Arrays;
import java.util.Scanner;

public class Array1D {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        int n = scan.nextInt();
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = scan.nextInt();
//        }
        int n = Integer.parseInt(scan.nextLine());
        //                                                        casting
        int[] a = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        /*
        5
        10
        20
        30
        40
        50
        10
        20
        30
        40
        50
         */
    }
}
