import java.util.*;

public class Linkedhasmap{
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("Nepal", 5);
        lhm.put("china", 150);
        System.out.println(lhm);
    }
}