import java.util.*;

public class Linkedhasmap {
    //LinkedHashSet
    public static void linkedhashset(){
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("Delhi");
        lhs.add("Patna");
        lhs.add("Mumbai");

        System.out.println(lhs);
    }

    public static void main(String[] args) {
        linkedhashset();
    }
}
