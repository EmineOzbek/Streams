import java.util.Comparator;
import java.util.List;

public class A1MaxAndComparator {

    public static A1Person getOldestPerson(List<A1Person> people) {
        A1Person oldestPerson = new A1Person("", 0);
        for (A1Person person : people) {
            if (person.getAge() > oldestPerson.getAge()) {
                oldestPerson = person;
            }
        }
        return oldestPerson;
    }

    public static A1Person getOldestPerson2(List<A1Person> people) {
        return people.stream()
                .max(Comparator.comparingInt(A1Person::getAge))
                .orElse(null);
    }

}
