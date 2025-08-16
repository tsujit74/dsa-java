/*NO duplicates 
unodered 
Null is allowed
it store unique value
it does not store same value */

import java.util.*;
import java.util.HashSet;

public class Hashset {
    public static void hashsetBasic() {
        HashSet<Integer> hs = new HashSet<>();
        hs.add(1);
        hs.add(2);
        hs.add(3);
        hs.add(2);// repeated value it not store in hasset
        System.out.println(hs);
        System.out.println(hs.size());
    }

    // Iteration on HashSet
    public static void iterationOnHashset() {
        HashSet<String> cities = new HashSet<>();
        cities.add("Delhi");
        cities.add("Patna");
        cities.add("Mumbai");

        System.out.println(cities);

        // Using Iterator
        Iterator it = cities.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();
        // or
        for (String city : cities) {
            System.out.print(city + " ");
        }
        System.out.println();
    }

    // COunt distinct Element
    // Ditinct mean unique element arr[] = {4,3,2,5,6,7,3,2,1}; Hint HashSet store
    // unique element
    public static void countDistinct() {
        int nums[] = { 4, 3, 2, 5, 6, 7, 3, 2, 1 };
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }
        System.out.println(hs.size());
    }

    // Union and Intersection of two array
    /*
     * arr1 = (7,3,9)
     * arr2 = (6,3,9,2,9,4)
     * union = 6 {7,3,9,6,2,4}
     * Interseciton = 2 {3,9}
     */
    public static void unionAndIntersection() {
        int arr1[] = { 7, 3, 9 };
        int arr2[] = { 6, 3, 9, 2, 9, 4 };
        HashSet<Integer> set = new HashSet<>();

        // Union
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        System.out.println("Union Element: " + set + ", size " + set.size());

        // Inter section
        set.clear();// now set is clear
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        int count = 0;
        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                count++;
                set.remove(arr2[i]);
            }
        }
        System.out.println("InterSection " + count);
    }

    // find intineary from tickets
    /*
     * "Chennai" -> "Benaluru"
     * "Mumbai" -> "Delhi"
     * "Goa" -> "Chennai"
     * "Delhi" -> "Goa"
     * Mumbai is starting point because it is not in the from to
     * Ans = Mumbai->Delhi->Goa->Chennai->Bengaluru
     */
    public static void findIntinearyTickets() {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Benaluru");
        tickets.put("Mumbai", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        String start = getStart(tickets);
        System.out.print(start);
        for (String key : tickets.keySet()) {
            System.out.print("->" + tickets.get(start));
            start = tickets.get(start);
        }
    }

    // find start point
    public static String getStart(HashMap<String, String> tickets) {
        HashMap<String, String> revMap = new HashMap<>();
        for (String key : tickets.keySet()) {
            revMap.put(tickets.get(key), key);
        }
        for (String key : tickets.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }
        return null;
    }

    /*
     * largest subarray with 0 sum
     * arr = {15,-2,2,-8,1,7,10,23} (-2+2+(-8)+1+7) = 0 TC = O(n)
     * ans = 5
     */
    public static void largestSubArray() {
        System.out.println();
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int len = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum)) {
                len = Math.max(len, j - map.get(sum));
            } else {
                map.put(sum, j);
            }
        }
        System.out.println("Largest subarray with sum as 0 = " + len);
    }

    /*
     * subarray sum equal to k
     * arr(1,2,3) k = 3
     * ans = (2),(1,2),(3) TC = O(n)
     */
    public static void subarrayEqualToK() {
        int arr[] = { 10, 2, -2, -20, 10 };
        int k = -10;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;

        for (int j = 0; j < arr.length; j++) {
            sum += arr[j];
            if (map.containsKey(sum - k)) {
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        System.out.println(ans);
    }

    public static void main(String args[]) {
        countDistinct();
        unionAndIntersection();
        findIntinearyTickets();
        largestSubArray();
        subarrayEqualToK();
    }
}