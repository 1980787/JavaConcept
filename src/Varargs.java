import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Varargs {
    public static void main(String[] args) {
//        List<Integer> STDIN = Arrays.asList(1,2,3,4,5,6);

//        int[] STDIN = new int[6];
//        try (Scanner sc = new Scanner (System.in)) {
//            int i = 0;
//            while (sc.hasNext() && i < 6) {
//                STDIN[i] = sc.nextInt();
//                i++;
//            }
//        }
//        System.out.println(Arrays.toString(STDIN));
//        sc.close();
        int[] STDIN = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(add(STDIN)));

    }

    static String[] add (int[] arr) {
        String[] result = new String[arr.length];
        int sum = arr[0];
        String print = arr[0] + "";
        for (int i = 1; i < arr.length; i++) {
            result[i -1] = print + "+" + arr[i] + "=" + sum;
            print += "+" + arr[i];
            sum += arr[i];
        }
        return result;
    }
}
