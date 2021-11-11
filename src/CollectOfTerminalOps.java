import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class CollectOfTerminalOps {
    public static void main(String[] args) {
        // collect() required Collector parameter
        // Used to collect elements of a stream and return the result of grouping or splitting into a collection.
        // Collector is an interface. Collectors is a class that provide written static method
        // Collector provide methods:
        // toList(), toSet(), toMap(), toCollection(), counting(), summingInt(), averagingInt(), maxBy(), minBy(), reducing(), joining(), groupingBy(), partitioningBy()
        // toList(), toSet(), toMap()
        Stream<Person> people = Stream.of(
                new Person("John", "William", 33),
                new Person("Jane", "Louis",  21),
                new Person("David", "London", 18)
        );
//        List<String> firstName = people.map(Person::getfName).collect(Collectors.toList());
////        System.out.println(firstName); // [John, Jane, David]

        // toCollection()
//        // To specify a specific collection not list or set, pass the constructor reference of the collection as a parameter to toCollection().
//        ArrayList<String> firstName2 = firstName.stream().collect(Collectors.toCollection(ArrayList::new));
//        System.out.println(firstName2);
//        ArrayList<String> lastName = people.map(Person::getlName).collect(Collectors.toCollection(ArrayList::new));
//        System.out.println("\n" + lastName); // [William, Louis, London]

        // Statistics
        // counting(), summingInt(), averagingInt(), maxBy(), minBy()
        // counting()
//        long count1 = people.count();
//        System.out.println(count1); // 3
//        long count2 = people.collect(counting());
//        System.out.println(count2); // 3

        // summingInt(), summingLong(), summingDouble()
//        long sum1 = people.mapToInt(Person::getAge).sum();
//        System.out.println(sum1); // 72
//        long sum2 = people.collect(summingInt(Person::getAge));
//        System.out.println(sum2); // 72
        // summrizingInt() with IntSummaryStatistics
//        IntSummaryStatistics stats = people.collect(summarizingInt(Person::getAge));
//        System.out.println(stats); // IntSummaryStatistics{count=3, sum=72, min=18, average=24.000000, max=33}
//        IntSummaryStatistics stats2 = people.mapToInt(Person::getAge).summaryStatistics();
//        System.out.println(stats2); // IntSummaryStatistics{count=3, sum=72, min=18, average=24.000000, max=33}

        // averagingInt(), averagingLong(), averagingDouble()
//        double avg1 = people.mapToDouble(Person::getAge).average().getAsDouble();
//        System.out.println(avg1); // 24.0
//        double avg2 = people.collect(averagingDouble(Person::getAge));
//        System.out.println(avg2); // 24.0

        // maxBy(), minBy()
//        int max1 = people.mapToInt(Person::getAge).max().getAsInt();
//        System.out.println(max1); // 33
//        Optional<Person> oldest = people.max(Comparator.comparingInt(Person::getAge));
//        System.out.println(oldest); // Optional[Person: fName=John, lName=William, age=33]
//        Optional<Person> oldest2 = people.collect(maxBy(Comparator.comparingInt(Person::getAge)));
//        System.out.println(oldest2.get()); // Person: fName=John, lName=William, age=33

        // reducing()
        // Stream<T>
//        System.out.println(people.map(Person::getAge).reduce(0, Integer::sum)); // 72
//        System.out.println(people.collect(reducing(0, Person::getAge, Integer::sum))); // 72
        // IntStream
        IntStream intStream = IntStream.rangeClosed(1, 10);
//        System.out.println(intStream.reduce(Integer::sum).getAsInt()); // 55
//        System.out.println(intStream.boxed().collect(reducing(Integer::sum)).get()); // 55
//        System.out.println(intStream.reduce(0, (a, b) -> a + b)); // 55
//        System.out.println(intStream.boxed().collect(reducing(0, (a, b) -> a + b))); // 55

        // joining() returns a string that concatenated all elements of a stream
        // only take CharSequence like string or StringBuffer
        // if the elements of the stream are not strings, convert stream to Strings using map().
//        String firstNames = people.map(Person::getfName).collect(joining());
//        System.out.println(firstNames); // JohnJaneDavid
//        String firstNames2 = people.map(Person::getfName).collect(joining(", "));
//        System.out.println(firstNames2); // John, Jane, David
//        String firstNames3 = people.map(Person::getfName).collect(joining(", ","[","]"));
//        System.out.println(firstNames3); // [John, Jane, David]

        // partitioningBy() classify as Predicate of stream elements
        // groupingBy() classify as Function of stream elements

    }
}
