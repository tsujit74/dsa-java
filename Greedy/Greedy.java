import java.util.*;
import java.util.ArrayList;

public class Greedy {

   // Activity selection for sorted end
   public static void activitySelection(int start[], int end[]) {
      // int start[] = { 1, 3, 0, 5, 8, 5 };
      // int end[] = { 2, 4, 5, 7, 9, 9 };

      // end time basis
      int maxAct = 0;
      ArrayList<Integer> ans = new ArrayList<>();
      // !st Activity
      maxAct = 1;
      ans.add(0);
      int lastEnd = end[0];
      for (int i = 1; i < end.length; i++) {
         if (start[i] >= lastEnd) {
            // activity select
            maxAct++;
            ans.add(i);
            lastEnd = end[i];
         }
      }
      System.out.println("Max Activities = " + maxAct);
      for (int i = 0; i < ans.size(); i++) {
         System.out.print("A" + ans.get(i) + " ");
      }
      System.out.println();
   }

   // activitty selection for unsorted
   public static void activitySelectionUnsorted(int start[], int end[]) {
      int activities[][] = new int[start.length][3];
      for (int i = 0; i < start.length; i++) {
         activities[i][0] = i;
         activities[i][1] = start[i];
         activities[i][2] = end[i];
      }
      // Lambda Function -> short form
      Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));

      // end time basic sorted
      int maxAct = 0;
      ArrayList<Integer> ans = new ArrayList<>();

      // 1st activity
      maxAct = 1;
      ans.add(activities[0][0]);
      int lastEnd = activities[0][2];
      for (int i = 1; i < end.length; i++) {
         if (activities[i][1] >= lastEnd) {
            // Activity selected
            maxAct++;
            ans.add(activities[i][0]);
            lastEnd = activities[i][2];
         }
      }
      System.out.println("MAx activities = " + maxAct);
      for (int i = 0; i < ans.size(); i++) {
         System.out.print("A" + ans.get(i) + " ");
      }
      System.out.println();
   }

   // fractonal knapsack problem
   public static void fractionalKanpSack(int val[], int wieght[], int cap) {
      double ratio[][] = new double[val.length][2];
      // 0th col => idx, 1st col => ratio

      for (int i = 0; i < val.length; i++) {
         ratio[i][0] = i;
         ratio[i][1] = val[i] / (double) wieght[i];
      }

      // ascending order
      Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));

      int capacity = cap;
      int finalVal = 0;
      for (int i = ratio.length - 1; i >= 0; i--) {
         int idx = (int) ratio[i][0];
         if (capacity >= wieght[idx]) { // include ful item
            finalVal += val[idx];
            capacity -= wieght[idx];
         } else {
            // incllude fractional value
            finalVal += (ratio[i][1] * capacity);
            capacity = 0;
            break;
         }
      }
      System.out.println("Final VAlue = " + finalVal);
   }

   // MInimum absolute pair difference for same length
   public static void absoluteDiff(int arr1[], int arr2[]) {
      Arrays.sort(arr1);
      Arrays.sort(arr2);
      int minDiff = 0;
      for (int i = 0; i < arr1.length; i++) {
         minDiff += Math.abs(arr1[i] - arr2[i]);
      }
      System.out.println("Minimum sum of absolute pair diffrence: " + minDiff);
   }

   // maximum length of chain pairs
   public static void maximumChain(int pairs[][]) {
      Arrays.sort(pairs, Comparator.comparingDouble(o -> o[1]));

      int chainLen = 1;
      int chainEnd = pairs[0][1]; // last selected pair end //chain end

      for (int i = 1; i < pairs.length; i++) {
         if (pairs[i][0] > chainEnd) {
            chainLen++;
            chainEnd = pairs[i][1];
         }
      }
      System.out.println("MAximum chain length of pair = " + chainLen);
   }

   // indian coins Ex = 590 = 500 50 20 20 total coin = 4
   public static void indianCoins(int amount) {
      Integer coins[] = { 1, 2, 5, 10, 20, 50, 100, 500, 12000 };

      Arrays.sort(coins, Comparator.reverseOrder());
      int countOfCoins = 0;
      ArrayList<Integer> ans = new ArrayList<>();
      for (int i = 0; i < coins.length; i++) {
         if (coins[i] <= amount) {
            while (coins[i] <= amount) {
               countOfCoins++;
               ans.add(coins[i]);
               amount -= coins[i];
            }
         }
      }
      System.out.println("Total (min) coin are used = " + countOfCoins);
      for (int i = 0; i < ans.size(); i++) {
         System.out.print(ans.get(i) + " ");
      }
      System.out.println();
   }

   // choclate problem divide whole choclate into single squares
   public static void choclateSquare() {
      // int n = 4, m = 6;
      Integer costVer[] = { 2, 1, 3, 1, 4 };
      Integer costHor[] = { 4, 1, 2 };

      Arrays.sort(costVer, Collections.reverseOrder());
      Arrays.sort(costHor, Collections.reverseOrder());

      int h = 0, v = 0;
      int hp = 1, vp = 1;
      int cost = 0;

      while (h < costHor.length && v < costVer.length) {
         if (costVer[v] <= costHor[h]) {// horizontal cuts
            cost += (costHor[h] * vp);
            hp++;
            h++;
         } else {// verticle cuts
            cost += (costVer[v] * hp);
            vp++;
            v++;
         }
      }

      while (h < costHor.length) {
         cost += (costHor[h] * vp);
         hp++;
         h++;
      }
      while (v < costVer.length) {
         cost += (costVer[v] * hp);
         vp++;
         v++;
      }

      System.out.println("Minimum cut of cuts = " + cost);
   }

   public static void main(String[] args) {
      indianCoins(1100);
      choclateSquare();
   }
}