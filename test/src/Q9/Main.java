package Q9;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class Main {
    public static void main(String[] args) {
        // Create a list of Person objects
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Alice", 30));
        persons.add(new Person("Bob", 25));
        persons.add(new Person("Charlie", 35));
        persons.add(new Person("David", 20));

        // Filter the list to include only persons with age greater than 25
        persons.removeIf(person -> person.getAge() <= 25);

        // Sort the resulting list based on their names
        persons.sort(Comparator.comparing(Person::getName));

        // Print the names of the filtered and sorted persons
        System.out.println("Names of persons with age greater than 25, sorted by name:");
        persons.forEach(person -> System.out.println(person.getName()));
    }
}
