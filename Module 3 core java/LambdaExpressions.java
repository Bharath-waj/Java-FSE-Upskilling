import java.util.*;
public class LambdaExpressions {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Charlie", "Alice", "Bob", "David");
        Collections.sort(names, (a, b) -> a.compareToIgnoreCase(b));
        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}
