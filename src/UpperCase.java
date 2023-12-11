import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class UpperCase {
    public static void main(String[] args) {

        System.out.println(mapToUppercase("Merhaba", "hello", "HOLa"));
        System.out.println(mapToUppercase2("Merhaba", "hello", "HOLa"));

    }

    public static Collection<String> mapToUppercase(String... names) {
        Collection<String> uppercaseNames = new ArrayList<>();
        for (String name : names) {
            uppercaseNames.add(name.toUpperCase());
        }
        return uppercaseNames;
    }

     /*
       Array elemanlarının tamamını al.  ->  stream()
       Büyük harflere çevir.             ->  map()
       Liste olarak geri dön.            ->  collect()
     */

    public static Collection<String> mapToUppercase2(String... names) {
        return Arrays.stream(names).map(String::toUpperCase).collect(Collectors.toList());
    }

}
