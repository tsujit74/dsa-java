import java.util.*;

public class Treema {
    public static void main(String[] args) {
        TreeMap<String, Integer> tm = new TreeMap<>();
        tm.put("c", 100);
        tm.put("a", 5);
        tm.put("b", 150);

        //based on key
        System.out.println(tm);
    }
}
