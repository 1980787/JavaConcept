public class Palindrome {
    public static void main(String[] args) {
        String str = "aba";
        System.out.println(str.length()/2);
        System.out.println(isPalindrome(str));
    }

    static boolean isPalindrome(String words) {
        // two pointer
        int end = words.length() -1;
        boolean result = false;
        if (words.length() == 1) {
            result = true;
        }
        for(int i = 0; i < words.length() /2; i++) {
            if (i < end) {
                if (words.charAt(i) == words.charAt(end)) {
                    result = true;
                } else {
                    result = false;
                }
                end--;
            }
        }
        return result;
    }
}
