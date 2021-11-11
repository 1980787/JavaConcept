import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TerminalOps {
    public static void main(String[] args) {
        // terminal operations
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
        Stream<Person> people = Stream.of(
                new Person("John", "William", 33),
                new Person("Jane", "Louis",  21),
                new Person("David", "London", 18)
        );
//        Person[] peopleList = people.toArray(Person[]::new);
//        Object[] peopleList2 = people.toArray();
//        System.out.println(peopleList); // [LPracticeStream$Person;@59a6e353
//        System.out.println(peopleList2); // [Ljava.lang.Object;@3d24753a
//        System.out.println(Arrays.toString(peopleList)); // [PracticeStream$Person@59a6e353, PracticeStream$Person@7a0ac6e3, PracticeStream$Person@71be98f5]
        // When creating own custom classes, override the Object.toString() method
        // If not, that return getClass().getName()+'@'+Integer.toHexString(hashCode())
//        System.out.println(Arrays.toString(peopleList)); // [Person: fName=John, lName=William, age=33, Person: fName=Jane, lName=Louis, age=21, Person: fName=David, lName=London, age=18] - overriden toString
//        System.out.println(Arrays.toString(peopleList2)); // [Person: fName=John, lName=William, age=33, Person: fName=Jane, lName=Louis, age=21, Person: fName=David, lName=London, age=18]
    }

    // Figuring out reduce() of terminal operations
    static int count (int identity, IntStream stream) {
        int a = identity;
        for (int b  : stream.toArray()) {
            a =  a + 1;
        }
        return a;
    }
    // Figuring out reduce() of terminal operations
    static int sum (int identity, IntStream stream) {
        int a = identity;
        for (int b  : stream.toArray()) {
            a =  a + b;
        }
        return a;
    }
}
