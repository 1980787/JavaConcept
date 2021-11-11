import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOps {
    public static void main(String[] args) {
        // Intermediate operations
        // distinct, filter, limit, skip, sorted, map, peek, flatMap
        // distinct() remove duplicate
        IntStream distinct = IntStream.of(1, 2, 2, 3, 3, 3, 4, 5, 5, 6); // 1 - 10
//        distinct.distinct().forEach(System.out::print); // 123456

        // filter() remove not match condition. use multiply
        IntStream filter = IntStream.rangeClosed(1, 10); // 1 - 10
//        filter.filter(i -> i % 2 == 0).forEach(System.out::print); // 246810
//        filter.filter(i -> i % 2 == 0 && i % 3 != 0).forEach(System.out::print); // 24810
//        filter.filter(i -> i % 2 == 0).filter(i -> i % 3 != 0).forEach(System.out::print); // 24810

        // limit() limit the number of result
        // skip() skip as input value
        IntStream skipNlimit = IntStream.rangeClosed(1, 10); // 1 - 10
//        skipNlimit.skip(3).limit(5).forEach(System.out::print); // 45678

        // sorted() sort as Comparator
        // thenComparing() add sort condition
        Stream<String> sort = Stream.of("dd", "aaa", "CC", "cc", "b");
//        sort.sorted().forEach(System.out::print); // CCaaabccdd - natural
//        sort.sorted(Comparator.reverseOrder()).forEach(System.out::print); // ddccbaaaCC - reverse
//        sort.sorted(String.CASE_INSENSITIVE_ORDER).forEach(System.out::print); // aaabCCccdd - case insensitive
//        sort.sorted(String.CASE_INSENSITIVE_ORDER.reversed()).forEach(System.out::print); // ddCCccbaaa - case insensitive and reverse
//        sort.sorted(Comparator.comparing(String::length)).forEach(System.out::print); // bddCCccaaa - length of string
//        sort.sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::print); // aaaddCCccb - length of string and reverse

        // map() to convert stream elements to other data type
        Stream<String> strMap = Stream.of("a", "b", "c", "d");
//        strMap.map(String::toUpperCase).forEach(System.out::print); // ABCD
        // mapToInt(), mapToLong(), mapToDouble() with parseInt(), valueOf()
        // mapToInt() Stream<String> -> IntStream
        Stream<String> str2Map = Stream.of("1", "2", "3", "4");
//        str2Map.mapToInt(Integer::parseInt).forEach(System.out::print); // 1234
        // mapToInt() : Stream<Integer> -> IntStream
        Stream<Integer> intMap = Stream.of(1, 2, 3, 4, 5);
//        intMap.mapToInt(Integer::intValue).forEach(System.out::print); // 12345
        // mapToObj(i -> i + ", ") : IntStream -> Stream<String>
        IntStream obj = new Random().ints(5, 1, 36);
//        obj.mapToObj(i -> i + ", ").forEach(System.out::print); // 28, 13, 21, 5, 5,
        Stream<Person> people = Stream.of(
                new Person("John", "William", 33),
                new Person("Jane", "Louis",  21),
                new Person("David", "London", 18)
        );
//        people.map(Person::getfName).forEach(System.out::print); // JohnJaneDavid
//        people.map(Person::getlName).forEach(System.out::print); // WilliamLouisLondon
//        people.map(Person::getAge).forEach(System.out::print); // 332118

        // boxed() : IntStream -> Stream<T>
        // collect() : Stream<T> -> List<T> or Set<T>
        // To convert a stream of primitives, the elements wrap in a box and then collect the wrapped objects in a collection.
        // List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).collect(Collectors.toList()); // Compilation Error!
//        List<Integer> ints = IntStream.of(1, 2, 3, 4, 5).boxed().collect(Collectors.toList());
//        System.out.println(ints);
        // Stream operations directly
//        System.out.println(IntStream.range(1, 5).boxed().max(Integer::compareTo)); // Optional[4]
//        System.out.println(IntStream.range(1, 5).boxed().max(Integer::compareTo).get()); // 4

        // peek(), flatMap()
    }
}
