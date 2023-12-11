import java.util.*;
import java.util.stream.Collectors;

public class FlatMap {
    public static void main(String[] args) {
        List<List<String>> collection = Arrays.asList(List.of("test1"), List.of("test2"));
        System.out.println(transform(collection));
        System.out.println(transform2(collection));
    }

    public static List<String> transform(List<List<String>> collection) {
        List<String> newCollection = new ArrayList<>();
        for (List<String> subCollection : collection) {
            for (String value : subCollection) {
                newCollection.add(value);
            }
        }
        return newCollection;
    }

    /*
      Nested List'e ait değerleri al.   -> stream()
      Her bir elemanı bir listeye ekle. -> flatMap()
     */

    public static List<String> transform2(List<List<String>> collection) {
        return collection.stream()
                .flatMap(Collection::stream)    // Stream<Stream<String>> -> Stream<String>
                .collect(Collectors.toList());  // Stream<String> -> List<String>
    }
}
