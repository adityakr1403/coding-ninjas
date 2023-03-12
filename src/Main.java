import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        Stream<Integer> s1 = nums.stream();
//        s1.forEach(n -> System.out.println(n));
//        Stream<Integer> s2 = s1.filter(n -> n % 2 == 0);

        Stream<Integer> s2 = s1.map(n->n*2);
        int result = s2.reduce(0,(c,e)->c+e);

//        s2.forEach(n-> System.out.println(n));
        System.out.println(result);
    }
}