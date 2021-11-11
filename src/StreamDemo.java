

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
// AmigosCode
public class StreamDemo {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Alice", Gender.FEMALE)
        );
        // Imperative approach - How
        System.out.println("Imperative approach");
        List<Person> females = new ArrayList<>(); // empty list
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female : females) {
            System.out.println(female);
        }
        // Declarative approach - What, Encapsulation
        // Trade-off in performance will occur,
        // but the reuse of verified codes can prevent mistakes in the low level and make stable coding.
        System.out.println("Declarative approach");

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        people.stream() // abstract mode
                .filter(personPredicate)
                .forEach(System.out::println);
//        List<Person> females2 = people.stream()
//                .filter(person -> FEMALE.equals(person.gender))
//                .collect(Collectors.toList()); // end operation Definition of how to collect stream elements.
//        females2.forEach(System.out::println);

        // Predicate return true or false

//        List<Person> females2 = people.stream()
//                .filter(personPredicate)
//                .collect(Collectors.toList());
//        females2.forEach(System.out::println);
    }
    static class Person {
        private final String name;
        private final Gender gender;
        // constructor
        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    enum Gender {
        MALE, FEMALE
    }
}
