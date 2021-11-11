import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PracticeStream {
    public static void main(String[] args) {
        // Functional Interface in java.util.function
        // java.lang.Runnable
        // Supplier<T>
        // Consumer<T>
        // Function<T, R> regular function. Take one param, return a result
        // BiFunction<T, U, R> Take two param, return a result
        // Predicate<T> condition. Take one param, return a boolean type result
        // BiPredicate<T, U> Take two param, return a boolean type result

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

        // IntSummaryStatistics class in java.lang.Object - java.util.IntSummaryStatistics
        // perform multiple mathematical terminal operations consume the elements of stream
        // terminal operations can use at once.
        // provide methods: getCount(), getSum(), getAverage(), getMin(), getMax()
        Stream<Person> people = Stream.of(
                new Person("John", "William", 33),
                new Person("Jane", "Louis",  21),
                new Person("David", "London", 18)
        );
        IntSummaryStatistics stats = people.mapToInt(Person::getAge).summaryStatistics();
        System.out.println("count = " + stats.getCount());
        System.out.println("sum = " + stats.getSum());
        System.out.println("avg = " + stats.getAverage());
        System.out.println("min = " + stats.getMin());
        System.out.println("max = "  + stats.getMax());
        /*
        Above the code works at same time and print these
            count = 3
            sum = 72
            avg = 24.0
            min = 18
            max = 33
         */

        // Optional<T> Generic wrapper Class contain any type of reference variables.
        // easy to check and handle null values
        // OptionalInt, OptionalLong, OptionalDouble
    }

}
