import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LetterCount {

    public static void main(String[] args) {

        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive("Merhaba", "hello", "HOLa"));
        System.out.println(getTotalNumberOfLettersOfNamesLongerThanFive2("Merhaba", "hello", "HOLa"));

    }

    public static int getTotalNumberOfLettersOfNamesLongerThanFive(String... names) {
        List<String> namesLongerThanFive = new ArrayList<>();
        int count = 0;
        for (String name : names) {
            if (name.length() > 5) {
                namesLongerThanFive.add(name);
                count = count + name.length();
            }
        }
        return count;
    }

      /*
         Array elemanlarını al.                                -> stream()
         5'ten uzun elemanları filtrele.                       -> filter()
         Filtrelediğin listedeki tüm harflerin sayısını getir. -> mapToInt()
         Harf sayılarını topla.                                -> sum()
      */

    public static int getTotalNumberOfLettersOfNamesLongerThanFive2(String... names) {
        return Arrays.stream(names)
                .filter(name -> name.length() > 5)  //Stream<String>
                .mapToInt(String::length)           // Stream<Integer>
                .sum();
    }

}
