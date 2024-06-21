package Q1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {
    public static void main(String[] args){

        List<Person> person = Arrays.asList(
                new Person("Muskan", 23, 50000),
                new Person("aadarsh", 22, 44000),
                new Person("Janvi", 21, 6600)

        );

        List<Person> result = person.stream()
                .filter(n->n.getAge()>30 && n.getSalary()<50000)
                .collect(Collectors.toList());

        result.forEach(System.out::println);




    }
}
