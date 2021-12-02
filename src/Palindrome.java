public class Palindrome {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(str.length()/2);
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String words) {
        // two pointer
        int start = 0;
        int end = words.length() -1;
        boolean result = false;

        if (words.length() == 1) {
            return true;
        }
        while (start < end) {
            if (words.charAt(start) == words.charAt(end)) {
                result = true;
            } else {
                result = false;
            }
            start++;
            end--;
        }
        return result;
    }
}
