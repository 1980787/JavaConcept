public class StringBasic {
    public static void main(String[] args) {
        // immutable class
        // The string in the created String instance can only be read and cannot be changed.
        String str = "Learn the coding concept of the java";
        // length() return the length of String
        System.out.println(str.length()); // 36

        // Cast
        // toLowerCase()
        System.out.println(str.toLowerCase()); // learn the coding concept of the java
        // toUpperCase()
        System.out.println(str.toUpperCase()); // LEARN THE CODING CONCEPT OF THE JAVA
        //
        // String -> Wrapper(Boolean, Integer, Long, Float, Double) ; A.valueOf(String s)
        // Byte.valueOf(String s), Short.valueOf(String s), Integer.valueOf(String s), Long.valueOf(String s), Float.valueOf(String s), Double.valueOf(String s)
        //
        // String -> primitive(boolean, char, int, long, float, double) ; A.parseA(String s)
        // Integer.parseInt(String s), Long.parseLong(String s), Float.parseFloat(String s), Double.parseDouble(String s)
        // Boolean.parseBoolean(String s), Byte.parseByte(String s), Short.parseShort(String s)
        // Integer.parseInt(String s) return int that primitive type, valueOf() return new Integer() object
        // Since JDK 1.5, there is no difference between when primitive type and wrapper class type because of the autoboxing function. 
        // So just use valueOf() without distinction, but valueOf() is a bit slower than parse().
        String intString = "1234";
        System.out.println(Integer.parseInt(intString)); // 1234
        System.out.println(Integer.valueOf(intString)); // 1234
        //
        // Primitive type(boolean, char, int, long, float, double, Object) -> String
        // valueOf(boolean b)
        System.out.println(String.valueOf(true)); // true that String
        // valueOf(char c)
        System.out.println(String.valueOf('c')); // c that String
        // valueOf(int i), valueOf(long l), valueOf(float f), valueOf(double d)
        System.out.println(String.valueOf(100)); // 100 that String
        System.out.println(String.valueOf(100L)); // 100 that String
        System.out.println(String.valueOf(100f)); // 100.0 that String
        System.out.println(String.valueOf(100.0)); // 100.0 that String
        // valueOf(Object o)
        System.out.println(String.valueOf(new java.util.Date())); // Mon Nov 15 15:29:47 EST 2021 that String

        // Find
        // substring(int index) return string from index to end
        System.out.println(str.substring(3)); // rn the coding concept of java
        // substring(int beginIndex, int endIndex) return string from beginIndex to endIndex - 1
        System.out.println(str.substring(3, 7)); // rn t
        // charAt(int index) return the character at the specified index.
        System.out.println(str.charAt(3)); // r
        // indexOf(Char ch) returns the index of the first occurrence of a specific character or string, and returns "-1" if not found.
        // indexOf(String str) returns the index of the first occurrence of a specific character or string, and returns "-1" if not found.
        // indexOf(Char ch, int pos) returns the index of the given character ch exists in the string from the specified position pos, and returns "-1" if not found.
        System.out.println(str.indexOf("the")); // 6
        // lastindexOf(String str) returns the index of the first occurrence of a specific character or string from the back, and returns "-1" if not found.
        System.out.println(str.lastIndexOf("the")); // 28
        // contains(CharSequence s) return boolean whether String contains or not
        System.out.println("abcdefg".contains("ab")); // true

        // Combine
        // concat(String str)
        System.out.println("Hello".concat(" world")); // Hello world
        // +
        System.out.println("Hello" + " world"); // Hello world
        // StringBuffer append()
        // The String class cannot change the string specified when creating an instance, but the StringBuffer class can change and thread safe.
        StringBuffer sb = new StringBuffer("Hello");
        System.out.println(sb.append(" world")); // Hello world

        // split(String regex) return string array divides by the specified regex
        String animals = "dog,cat,bear";
        String[] arr = animals.split(",");
        String[] arr2 = str.split(" ");
        for (String s : arr) {
            System.out.println(s);
            /*
            dog
            cat
            bear
             */
        }
        for (String s : arr2) {
            System.out.println(s);
            /*
            Learn
            the
            coding
            concept
            of
            the
            java
             */
        }
        // join(String regex, String[] arr) Combine multiple strings by regex between of strings
        System.out.println(String.join("-", arr2)); // Learn-the-coding-concept-of-the-java

        // Remove/replace blank
        // replace(char old, char nw) returns a string in which the old character in the string is replaced with the new character.
        // replace(CharSequence old, charSequence nw)
        System.out.println(str.replace("the", "THE")); // Learn THE coding concept of THE java
        // replaceAll(String regex, String nw) replace all strings that match the specified regex to nw strings.
        System.out.println(str.replaceAll(" ", "")); // Learnthecodingconceptofthejava
        // trim() Returns the result of removing whitespace from the left and right ends of the string. Spaces in the middle of the string are not removed.

        // Compare
        // String literals reuse something that already exists at constant pool in JVM
        String compareStr1 = "abc"; // The address of the string literal "abc" is stored in compareStr1.
        String compareStr2 = "abc"; // The address of the string literal "abc" is stored in compareStr2.
        // When the constructor of the String class is used, memory allocated by the new operator, so a new String instance is created.
        String compareStr3 = new String("abc"); // Create new String instance
        String compareStr4 = new String("abc"); // Create new String instance
        // == compare instance's memory of Strings
        System.out.println(compareStr1 == compareStr2); // true
        System.out.println(compareStr3 == compareStr4); // false
        // equals(Object obj) compare contents of Strings
        System.out.println(compareStr1.equals(compareStr2)); // true
        System.out.println(compareStr3.equals(compareStr4)); // true
        // equalsIgnoreCase(String str)
        // compareTo() Compare Strings in alphabetical order.
        // 0 if they are equal, -1 if they are before, +1 if they are after.
        System.out.println("\"aaa\".compareTo(\"aaa\") : " + "aaa".compareTo("aaa")); // 0
        System.out.println("\"aaa\".compareTo(\"bbb\") : " + "aaa".compareTo("bbb")); // -1
        System.out.println("\"bbb\".compareTo(\"aaa\") : " + "bbb".compareTo("aaa")); // 1

        // format()
        System.out.println(String.format("%d plus %d is %d", 3, 5, 3 + 5)); // 3 plus 5 is 8
    }
}
