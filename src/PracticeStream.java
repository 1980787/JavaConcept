import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeStream {
    public static void main(String[] args) {
        // Collection Framework
        // Stream, List, Set, Queue, Dequeue
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Stream<Integer> instStream = list.stream();
//        instStream.forEach(System.out::print); // 12345
        // Array
        String[] strArr = {"a", "b", "c", "d"};
        Stream<String> strStream = Stream.of(strArr);
        Stream<String> strStream2 = Stream.of("a", "b", "c", "d");
        Stream<String> sStream = Stream.of(new String[] {"a", "b", "c", "d"});
        Stream<String> tStream = Arrays.stream(new String[] {"a", "b", "c", "d"});
        Stream<String> rStream = Arrays.stream(new String[] {"a", "b", "c", "d"}, 0, 3);
//        rStream.forEach(System.out::print); // abc
        // EmptyStream
        // It is better to return an empty stream than null when there is no result of an operation on the stream.
        Stream emptyStream = Stream.empty();
//        emptyStream.forEach(System.out::print); //

        // Primitive data type Stream
        // int, long, double
        int[] intArr = {1, 2, 3, 4, 5};
        IntStream intStream = IntStream.of(intArr);
        IntStream intStream2 = IntStream.of(1, 2, 3, 4, 5);
        IntStream iStream = IntStream.of(new int[] {1, 2, 3, 4, 5});
        IntStream nStream = Arrays.stream(new int[] {1, 2, 3, 4, 5});
        IntStream tegerStream = Arrays.stream(new int[] {1, 2, 3, 4, 5}, 0, 3);
//        tegerStream.forEach(System.out::print); // 123
        IntStream range = IntStream.range(1, 5);
//        range.forEach(System.out::print); // 1234
        IntStream rangeClosed = IntStream.rangeClosed(1, 5);
//        rangeClosed.forEach(System.out::print); // 12345
        // provide default method for easy to operate numbers
        // sum(), average(), max(), min()
//        System.out.println(intStream.sum()); // 15
//        System.out.println(intStream.average()); // OptionalDouble[3.0]
//        System.out.println(intStream.average().getAsDouble()); // 3.0
//        System.out.println(intStream.max()); // OptionalInt[5]
//        System.out.println(intStream.max().getAsInt()); // 5
//        System.out.println(intStream.min()); // OptionalInt[1]
//        System.out.println(intStream.min().getAsInt()); // 1
        // IntSummaryStatistics is used when you need to call multiple operation methods to obtain a value.
        // Steam is one-time use, so it is closed when used once

        // concat() connect two Stream
        Stream<String> str1 = Stream.of("123", "456", "789");
        Stream<String> str2 = Stream.of("ABC", "abc", "DEF");
//        Stream<String> connect = Stream.concat(str1, str2);
//        connect.forEach(System.out::print); // 123456789ABCabcDEF
//        Stream.concat(str1, str2).forEach(System.out::print); // 123456789ABCabcDEF

        // Random number
        // IntStream ints(), Integer.MIN_VALUE <= ints() <= Integer.MAX_VALUE
        // LongStream longs(), Long.MIN_VALUE <= longs() <= Long.MAX_VALUE
        // DoubleStream doubles(), 0.0 <= doubles() <= 1.0
        IntStream landomIntStream = new Random().ints(); // infinite stream, so with limit() intermediate operation
//        landomIntStream.limit(5).forEach(System.out::println); // print 5 integer range random number
        IntStream landomIntStream2 = new Random().ints(5);  // finite stream
//        landomIntStream2.forEach(System.out::println); // print 5 integer random number
        IntStream landomIntStream3 = new Random().ints(0, 100); // infinite stream,so with limit() intermediate operation
//        landomIntStream3.limit(5).forEach(System.out::println); // print 5 random number that bound 0 <= r < 100
        IntStream landomIntStream4 = new Random().ints(5, -100, 10); // finite stream
//        landomIntStream4.forEach(System.out::println); // print 5 random number that bound -100 <= r < 10

        // Intermediate operation
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
        // map() converting stream elements
        Stream<String> strMap = Stream.of("a", "b", "c", "d");
//        strMap.map(String::toUpperCase).forEach(System.out::print); // ABCD
        // mapToInt(), mapToLong(), mapToDouble() with parseInt(), valueOf()
        // Stream<String> -> IntStream
        Stream<String> str2Map = Stream.of("1", "2", "3", "4");
//        str2Map.mapToInt(Integer::parseInt).forEach(System.out::print); // 1234
        // Stream<Integer> -> IntStream
        Stream<Integer> intMap = Stream.of(1, 2, 3, 4, 5);
//        intMap.mapToInt(Integer::intValue).forEach(System.out::print); // 12345
        // mapToObj()
        // IntStream -> Stream<String>
        IntStream obj = new Random().ints(5, 1, 36);
        obj.mapToObj(i -> i + ", ").forEach(System.out::print); // 28, 13, 21, 5, 5,
        // peek(), flatMap()

        // final operation
        // forEach(), forEAchOrdered(), count(), max(), min(), findAny(), findFirst(),
        // allMatch(), anyMatch(), noneMatch(), toArray(), reduce(), collect()
    }
}
