public class ReverseString {
    public static void main(String[] args) {
        String str = "test reverse";
        System.out.println(reverse(str));
    }

    static String reverse(String str) {
        String reverse = "";
        for (int i = 0; i < str.length(); i++) {
            reverse = str.charAt(i) + reverse;
        }
        return reverse;
    }
}
