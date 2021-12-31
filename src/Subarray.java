import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Subarray {
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

        int neg = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = a[j] + sum;
                if (sum < 0) {
                    neg++;
                }
            }
        }
        System.out.println(neg);
    }

}
