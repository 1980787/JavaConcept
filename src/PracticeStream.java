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
//        obj.mapToObj(i -> i + ", ").forEach(System.out::print); // 28, 13, 21, 5, 5,
        // peek(), flatMap()

        // Optional<T> Generic wrapper Class contain any type of reference variables.
        // easy to check and handle null values
        // OptionalInt, OptionalLong, OptionalDouble

        // final operations
        // Print: forEach(), forEachOrdered()
        // non-primitive data type statistics: count(), max(), min() -> recommend to use primitive type stream
        // Check condition: allMatch(), anyMatch(), noneMatch() - required Predicate parameter, return boolean
        //                  findAny(), findFirst() - return Optional<T> type
        // allMatch() satisfy all elements
        IntStream allMatch = IntStream.rangeClosed(1,  10);
        IntStream allMatch2 = IntStream.of(2, 4, 6, 8, 10);
//        System.out.println(allMatch.allMatch(i -> i % 2 == 0)); // false, 1, 3, 5, 7, 9 is not matched
//        System.out.println(allMatch2.allMatch(i -> i % 2 == 0)); // true, 2, 4, 6, 8, 10 is all matched
        // anyMatch() satisfy anyone of elements
//        System.out.println(allMatch.anyMatch(i -> i % 2 == 0)); // true, 2, 4, 6, 8,10 matched
        // nonMatch() not satisfy all elements
//        System.out.println(allMatch.noneMatch(i -> i > 100)); // true, all elements is less than 100, so all elements are not matched the condition.
        // reduce() calculate by decreasing the elements of the stream one by one
        // reduce(BinaryOperator<T> accumulator) return Optional<T>
        // reduce(T identity, BinaryOperator<T> accumulator) return T
        // reduce(U identity, BiFunction<U, T, U>, BinaryOperator<T> combiner) return U - parallel stream
        // identity that starting number
        IntStream reduce = IntStream.rangeClosed(1, 10);
//        System.out.println(reduce.reduce((a, b) -> a > b ? a : b)); // OptionalInt[10] - get max value
//        System.out.println(reduce.reduce((a, b) -> a > b ? a : b).getAsInt());  // 10
//        System.out.println(reduce.reduce(Integer::max)); // OptionalInt[10] using static max method in Integer Class
//        System.out.println(reduce.reduce(0, (a, b) -> a + 1)); // 10 - get count
//        System.out.println(count(0, reduce)); // 10
//        System.out.println(reduce.reduce(0, (a, b) -> a + b)); // 55  - get sum
//        System.out.println(sum(0, reduce)); // 55
        // toArray() returns all elements of a stream as an array
//        System.out.println(Arrays.toString(reduce.toArray()));
        // collect() required Collector parameter
        // Used to collect elements of a stream and return the result of grouping or splitting into a collection.
        // Collector is an interface
        // Collectors is a class that provide written static method
        Stream<Person> people = Stream.of(
                new Person ("John", "William", 33),
                new Person ("Jane", "Louis",  21),
                new Person ("David", "London", 18)
        );
//        people.map(Person::getfName).forEach(System.out::print); // JohnJaneDavid
//        people.map(Person::getlName).forEach(System.out::print); // WilliamLouisLondon
//        people.map(Person::getAge).forEach(System.out::print); // 332118
        // toList(), toSet(), toArray() with Collectors
        // toMap(), toCollection() with Collectors
//        List<String> firstName = people.map(Person::getfName).collect(Collectors.toList());
//        System.out.println(firstName); // [John, Jane, David]
        Person[] lastName = people.toArray(Person[]::new);
//        System.out.println(lastName); // [LPracticeStream$Person;@59a6e353
//        System.out.println(Arrays.toString(lastName)); // [PracticeStream$Person@59a6e353, PracticeStream$Person@7a0ac6e3, PracticeStream$Person@71be98f5]

    }
    // Figuring out reduce() of final operations
    static int count (int identity, IntStream stream) {
        int a = identity;
        for (int b  : stream.toArray()) {
            a =  a + 1;
        }
        return a;
    }
    // Figuring out reduce() of final operations
    static int sum (int identity, IntStream stream) {
        int a = identity;
        for (int b  : stream.toArray()) {
            a =  a + b;
        }
        return a;
    }
    // Figuring out
    // map() of intermediate operations
    // collect() of final operations
    static class Person {
        private String fName;
        private String lName;
        private int age;

        Person(String fName, String lName, int age) {
            this.fName = fName;
            this.lName = lName;
            this.age = age;
        }
        String getfName() {
            return fName;
        }
        String getlName() {
            return lName;
        }
        int getAge() {
            return age;
        }
     }
}
