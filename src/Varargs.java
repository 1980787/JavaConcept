public class Varargs {
    public static void main(String[] args) {
        add(1, 2, 3, 4, 5, 6);
    }

    static void add (int... num) {
        int sum = 0;
        String result = "";
        for (int i = 0; i < num.length; i++) {
            sum += num[i];
            if (i < num.length -1) {
                result += num[i] + "+";
            } else {
                result += num[i];
            }
        }
        System.out.print(result);
        System.out.println("=" + sum);
    }
}
