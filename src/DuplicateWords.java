import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {
    public static void main(String[] args) {
        // Grouping of regex
        // () are used for grouping of regex phrases.
        // The \b boundaries are needed for special cases such as "Bob and Andy" (we don't want to match "and" twice).
        // Another special case is "My thesis is great" (we don't want to match "is" twice).
        // The second word always either comes before a space or as the very last thing matched,
        // so the word boundaries /b before the spaces don't need asserted
        // \b start of word boundary
        // \w a word character: [a-zA-Z_0-9]
        // ?: non-capturing group that can't do group() to get the group, for slightly faster performance
        // \s whitespace characters(spaces, tabs, newlines- tabs appear in some of the tests)
        // \W+ a non-word character: [^\w] e.g., space
        // \1 matches whatever was matched in the 1st group of parentheses, which in this case is the (\w+)
        // \b end of word
        // ()+ Repeating again
        // * can match zero times, + only repeated words match
        String regex = "\\b(\\w+)(?:\\s+\\1)+\\b"; // "\\b(\\w+)(?:\\W+\\1\\b)+";

        // case-insensitive
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Scanner in = new Scanner(System.in);
        int numSentences = Integer.parseInt(in.nextLine());

        while (numSentences-- > 0) {
            String input = in.nextLine();

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                // m.group() that entire match
                // m.group(i) i th match
                // replaceAll that each repeated word is replaced
                // with the very first instance the word found in the sentence.
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
            /*
            7
            Goodbye bye bye world world world
            Goodbye bye world
            Sam went went to to to his business
            Sam went to his business
            Reya is is the the best player in eye eye game
            Reya is the best player in eye game
            in inthe
            in inthe
            Hello hello Ab aB
            Hello Ab
            1 umair umair i am i am i i i i am not a a a good man
            1 umair i am i am i am not a good man
            lotto to roll over
            lotto to roll over
             */
        }
        in.close();
    }

}
