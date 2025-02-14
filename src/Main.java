import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        //Popular Intermediate ops (8)
        filterMethod();
        mapMethod();
        flatMapMethod();
        distinctMethod();
        sortedMethod();
        peekMethod();
        skipMethod();
        limitMethod();


    }

    // 14/02/2025
    // Create Stream

    //Under Construction

    // Basic Stream Intermediate Methods

    //filter
    private static void filterMethod(){

        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        list.stream().filter(number -> number < 5).forEach(System.out::println);

        List<Integer> filteredList = list.stream().filter(n -> n < 5).collect(Collectors.toList());
        System.out.println(filteredList);
    }

    //map
    private static void mapMethod(){

        List<String> list = Arrays.asList("apple", "banana", "orange");
        list.stream().map(String::toUpperCase).forEach(System.out::println);

        List<String> mappedList = list.stream().map(String::toUpperCase).toList();
        System.out.println(mappedList);
    }

    //flatmap return type should be a stream
    private static void flatMapMethod(){

        List<List<String>> list = new ArrayList<>();
        list.add(List.of("apple", "banana"));
        list.add(List.of("orange", "fruit"));

        list.stream().flatMap(Collection::stream).forEach(System.out::println);
        List<String> flatMappedList = list.stream().flatMap(Collection::stream).toList();
        System.out.println(flatMappedList);
    }

    //distinct
    //using distinct method to preserve the order otherwise would have used set
    private static void distinctMethod(){

        List<Integer> list = List.of(1,2,3,2,4,3,4,2,5,4,3,5,5,6);

        List<Integer> distinctList = list.stream().distinct().toList();
        System.out.println(distinctList);
    }

    //sorted
    private static void sortedMethod(){

        List<Integer> list = List.of(1,2,3,2,4,3,4,2,5,4,3,5,5,6);

        List<Integer> reverseSortedList = list.stream().sorted(Comparator.reverseOrder()).toList();
        System.out.println(reverseSortedList);

    }

    //peek
    //Used for debugging purpose, without modifying the stream if some intermediate ops needs to be performed then use peek
    private static void peekMethod(){

        List<String> list = Arrays.asList("apple", "banana", "cherry");

        list.stream().peek(word -> System.out.println("Original:" + word)).map(String::toUpperCase).forEach(System.out::println);

    }

    //skip
    public static void skipMethod(){

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        list.stream().skip(2).forEach(System.out::println);

    }

    //limit
    public static void limitMethod(){

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        list.stream().limit(4).forEach(System.out::println);
    }


}