import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class A1DistinctPersonIds {
    public static void main(String[] args) {


    }

    private List<Long> getDistinctEmployments2(final LocalDate startDate, final LocalDate endDate, final List<Long> unitIds) {
        List<A1Person> employmentList = new ArrayList<>();
        A1Person person = new A1Person("Emine", 25);
        A1Person person2 = new A1Person("Kuzey", 12);
        for (var unitId : unitIds) {
            employmentList.addAll(List.of(person, person2));
        }
        List<Long> employmentIds = new ArrayList<>();
        for (var employment : employmentList) {
            employmentIds.add(employment.getId());
        }
        return employmentIds;
    }

    private List<Long> getDistinctEmployments(final LocalDate startDate, final LocalDate endDate, final List<Long> unitIds) {
        A1Person person = new A1Person("Emine", 25);
        A1Person person2 = new A1Person("Kuzey", 12);
        return unitIds.stream()
                .flatMap(id -> List.of(person, person2).stream())
                .map(A1Person::getId)
                .distinct()
                .toList();
    }
}
