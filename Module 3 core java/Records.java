import java.util.*;
import java.util.stream.Collectors;
record Person(String name, int age) {}
public class Records {
    public static void main(String[] args) {
        List<Person> people = List.of(
            new Person("Alice", 30),
            new Person("Bob", 22),
            new Person("Charlie", 17),
            new Person("Diana", 25)
        );
        System.out.println("All Persons:");
        people.forEach(System.out::println);
        List<Person> adults = people.stream()
                                    .filter(p -> p.age() >= 18)
                                    .collect(Collectors.toList());
        System.out.println("\nAdults:");
        adults.forEach(System.out::println);
    }
}