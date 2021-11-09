import java.util.Arrays;
import java.util.Locale;

public class Anagram {
    // dad, add
    public static void main(String[] args) {
        char[] str1 = ("Fried").toLowerCase().toCharArray();
        char[] str2 = ("Fired").toLowerCase().toCharArray();

        if (areAnagram(str1, str2)) {
            System.out.println(Arrays.toString(str1) + " and " + Arrays.toString(str2) + " are anagram.");
        } else {
            System.out.println(Arrays.toString(str1) + " and " + Arrays.toString(str2) + " are not anagram.");
        }
        DBConnector db1 = DBConnector.getDbConnector();
        DBConnector db2 = DBConnector.getDbConnector();
        System.out.println(db1.equals(db2));
    }

    static boolean areAnagram(char[] str1, char[] str2) {
        // capital letter 26 small letter 26
        // asc 256
        int[] arr = new int[26];
        if (str1.length != str2.length) {
            return false;
        }
        for (int i = 0; i < str2.length; i++) {
            arr[str1[i] - 'a']++;
            arr[str2[i] - 'a']--;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
