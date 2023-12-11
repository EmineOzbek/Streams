import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class A1UnderAge {

    public static Set<String> getKidNames2(List<A1Person> people) {
        Set<String> kids = new HashSet<>();
        for (A1Person person : people) {
            if (person.getAge() < 18) {
                kids.add(person.getName());
            }
        }
        return kids;
    }

    public static Set<String> getKidNames(List<A1Person> people) {
        return people.stream()
                .filter(person -> person.age < 8)  // Stream<Person>
                .map(A1Person::getName)          // Stream<String>
                .collect(Collectors.toSet());
    }
}
