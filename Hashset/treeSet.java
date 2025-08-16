import java.util.*;

public class treeSet {
    //TreeSet //Sorted in ascending order
    public static void treeSets(){
        TreeSet<String> ts = new TreeSet<>();
        TreeSet<Integer> tn = new TreeSet<>();
        ts.add("Delhi");
        ts.add("Patna");
        ts.add("Mumbai");
        System.out.println(ts);
        tn.add(6);
        tn.add(2);
        tn.add(1);
        tn.add(2);
        System.out.println(tn);
    }
    public static void main(String[] args) {
        treeSets();
    }
}
