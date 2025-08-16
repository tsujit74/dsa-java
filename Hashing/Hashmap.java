import java.util.*;

public class Hashmap {
  // basic hash map
  public static void basicHashMap() {
    HashMap<String, Integer> hm = new HashMap<>();
    hm.put("India", 100);
    hm.put("Nepal", 5);
    hm.put("china", 150);

    System.out.println(hm);
    System.out.println(hm.containsKey("india"));
    System.out.println(hm.remove("china"));
    System.out.println(hm);
    hm.clear();
    System.out.println(hm);
  }

  // Iteration on hashmap
  public static void Iteration() {
    HashMap<String, Integer> hmap = new HashMap<>();
    hmap.put("India", 100);
    hmap.put("Nepal", 5);
    hmap.put("china", 150);

    // iterate
    Set<String> keys = hmap.keySet();
    System.out.println(keys);

    for (String k : keys) {
      System.out.println(k + " " + hmap.get(k));
    }
  }

  // Majority element nums[] = {1,3,2,5,1,3,1,5,1} ans = 1 because 1 appear more
  // times n/3
  public static void majorityElements(int arr[]) {
    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(arr[i])) {
        map.put(arr[i], map.get(arr[i]) + 1);
      } else {
        map.put(arr[i], 1);
      }
    }

    Set<Integer> keySet = map.keySet();
    for (Integer key : keySet) {
      if (map.get(key) > (arr.length / 3)) {
        System.out.println(key);
      }
    }
  }

  // Angram s = "race" t = "care" length and same character will use for another
  // the return true
  public static boolean isAngaram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char ch = s.charAt(i);
      map.put(ch, map.getOrDefault(ch, 0) + 1);
    }

    for (int i = 0; i < t.length(); i++) {
      char ch = t.charAt(i);
      if (map.get(ch) != null) {
        if (map.get(ch) == 1) {
          map.remove(ch);
        } else {
          map.put(ch, map.get(ch) - 1);
        }
      } else {
        return false;
      }
    }
    return map.isEmpty();
  }

  public static void main(String args[]) {
    String s = "race";
    String t = "car";
    System.out.println(isAngaram(s, t));

    int arr[] = {1,3,2,5,1,3,1,5,1};
    majorityElements(arr);
  }
}