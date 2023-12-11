import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream {

    public static void main(String[] args) {
        A1Person personel = new A1Person("Emine", 25);
        A1Person personel1 = new A1Person("Oğuzhan", 29);


        List<A1Person> personnelList = new ArrayList<>();
        personnelList.add(personel);
        personnelList.add(personel1);

        personel.setAddress(Arrays.asList("Samsun", "Atakum"));
        personel1.setAddress(Arrays.asList("Samsun", "Ayvacık"));

        // sumOfPersonelAges(personnelList);
        // streamSumOfPersonelAges(personnelList);
        // streamSumOfPersonelAges(personnelList);
        // findCityNames(personnelList);
        // test(personnelList);
        test2(personnelList);
    }

    //Stream kullanmadan personellerin yaşları toplamını bulma
    public static int sumOfPersonelAges(List<A1Person> personnelList) {

        int ageSum = 0;
        for (A1Person personnel : personnelList) {
            ageSum += personnel.getAge();
        }
        System.out.println(ageSum);
        return ageSum;
    }

    //Stream kullanarak personellerin yaşları toplamını bulma
    public static int streamSumOfPersonelAges(List<A1Person> personnelList) {

        System.out.println(personnelList.stream().mapToInt(A1Person::getAge).sum());
        return personnelList.stream().mapToInt(A1Person::getAge).sum();
    }

    //Stream.filter - Yaşı 25'ten büyük olan personellerin adresini bulma
    private static List<A1Person> findCityNames(List<A1Person> personnelList) {

        List<A1Person> list = personnelList.stream().filter(p -> p.getAge() > 25).collect(Collectors.toList());
        list.forEach((n) -> System.out.println(n.getName() + "->" + n.getAddress()));
        return list;
    }

    //parallelStream kullanmadan
    public static void test(List<A1Person> personnelList) {

        for (A1Person personel : personnelList) {

            try {
                Thread.sleep(1000);                 // get personnel info
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name : " + Thread.currentThread().getName());
        }
    }

    //parallelStream kullanarak
    public static void test2(List<A1Person> personnelList) {

        personnelList.parallelStream().forEach(personnel -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread name : " + Thread.currentThread().getName());
        });
    }
}
