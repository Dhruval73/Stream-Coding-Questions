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

        //Popular Terminal ops(11)
        forEachMethod();
        collectMethod();
        reduceMethod();
        allMatchMethod();
        findAnyMethod(); // not intuitive
        maxMethod(); //comparator needed
        toArrayMethod(); //String[]::new

        //Collectors methods

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
    private static void skipMethod(){

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        list.stream().skip(2).forEach(System.out::println);

    }

    //limit
    private static void limitMethod(){

        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9);

        list.stream().limit(4).forEach(System.out::println);
    }

    //Terminal ops
    //forEach
    private static void forEachMethod(){

        List<String> list = Arrays.asList("apple", "banana", "orange", "mango");

        list.stream().forEach(word -> System.out.println("Fruit: " + word));
    }

    //collect
    private static void collectMethod(){

        List<Integer> list = List.of(1,2,3,2,4,3,4,2,5,4,3,5,5,6);

        Set<Integer> set = list.stream().collect(Collectors.toSet());
        System.out.println(set);
    }

    //reduce > it performs a binary operation > takes 2 args and produce a single result > returns an optional
    private static void reduceMethod(){

        List<Integer> list = List.of(1,2,3,4,5,6);

        Optional<Integer> factorial = list.stream().reduce((a, b) -> a*b);

        System.out.println(factorial.get());
    }

    //allMatch, anyMatch and noneMatch > all are short-circuiting meaning they will stop once the condition is fulfilled in case a predicate is fulfilled.
    // allMatch > all elements match the given predicate, and so on
    private static void allMatchMethod(){

        List<Integer> list = List.of(2,4,6,4,8,6);

        boolean even = list.stream().allMatch(a -> a%2== 0);
        System.out.println(even);
    }

    //findFirst, findAny > short-circuiting > it doesnt take a predicate as one might think, but it is used in combination with filter and return any element or first element
    private static void findAnyMethod(){

        List<String> list = Arrays.asList("apple", "banana", "bean", "bulbasaur");

        Optional<String> bWord = list.stream().parallel().filter(word -> word.startsWith("b")).findAny();
        System.out.println(bWord);
    }

    //min and max > passing comparator is compulsary
    private static void maxMethod(){
        List<Integer> list = List.of(2,4,6,4,8,6);

        Optional<Integer> maxInt = list.stream().max(Integer::compareTo);
        System.out.println(maxInt);

    }

    //toArray
    private static void toArrayMethod(){
        List<String> words = Arrays.asList("apple", "banana", "orange", "mango");

        String[] arrWord = words.stream().toArray(String[]::new);
        System.out.println(Arrays.toString(arrWord));
    }
}
