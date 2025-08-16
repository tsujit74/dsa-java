import java.util.ArrayList;
import java.util.Collections;

public class arrayList {

  public static void operation(ArrayList<Integer> list) {
    int ele = list.get(3);
    list.remove(1);
    System.out.println("Index 3 elment: " + ele);
    System.out.println("Size of list: " + list.size());
  }

  // REVERSE
  public static void printRev(ArrayList<Integer> list) {
    for (int i = list.size() - 1; i >= 0; i--) {
      System.out.print(list.get(i) + " ");
    }
    System.out.println();
  }

  // MAXIMUM & MINIMUM
  public static void fintMaximum(ArrayList<Integer> list) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < list.size(); i++) {
      if (max < list.get(i)) {
        max = list.get(i);
      } else if (min > list.get(i)) {
        min = list.get(i);
      }
    }
    System.out.println("Maximum element: " + max);
    System.out.println("Minimum element: " + min);
  }

  // SWAP
  public static void swapTwo(ArrayList<Integer> list) {
    int ind1 = 0;
    int ind2 = 4;
    for (int i = 0; i < list.size(); i++) {
      int temp = list.get(ind1);
      list.set(ind1, list.get(ind2));
      list.set(ind2, temp);
    }
    System.out.println("After Swaping: " + list);
  }

  // REMOVE EVEN NUMBER
  public static void removeEven(ArrayList<Integer> list) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) % 2 == 0) {
        list.remove(i);
      }
    }
    System.out.println("Remove Even number: " + list);
  }

  // REVERSE STRING
  public static void reverseString(ArrayList<String> name) {
    for (int i = name.size() - 1; i >= 0; i--) {
      System.out.print(name.get(i) + " ");
    }
    System.out.println();
  }

  // ELEMENT EXIST OR NOT
  public static int findElement(ArrayList<Integer> list, int key) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i) == key) {
        return i;
      }
    }
    return -1;
  }

  // ADD TWO STRING LIST
  public static void addString(ArrayList<String> name1, ArrayList<String> name2) {
    ArrayList<String> bothList = new ArrayList<>(name1);
    bothList.addAll(name2);
    System.out.println(bothList);
  }

  // REMOVE DUPLICATE
  public static void removeDuplicate(ArrayList<Integer> list) {
    System.out.println("Remove Duplicate: ");
    for (int i = 1; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        if (list.get(j) == list.get(i)) {
          list.remove(i);
        }
      }
    }
  }

  // INTERCATION OF LIST :- [2,3,4,5] [3,4,1,2] op = [3,4]
  public static void interSection(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
    for (int i = 0; i < list1.size(); i++) {
      for (int j = 0; j < list2.size(); j++) {
        if (list1.get(i) == list2.get(j)) {
          list3.add(list1.get(i));
        }
      }
    }
  }

  // Sorting in arrray list
  public static void sorting(ArrayList<Integer> list) {
    Collections.sort(list);
  }

  // MULTI DIMENSIONAL ARRAY
  public static void multiDimensional(ArrayList<Integer> list1, ArrayList<Integer> list2, ArrayList<Integer> list3) {
    ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
    mainList.add(list1);
    mainList.add(list2);
    mainList.add(list3);
    System.out.println(mainList);

    for (int i = 0; i < mainList.size(); i++) {
      ArrayList<Integer> currList = mainList.get(i);
      for (int j = 0; j < currList.size(); j++) {
        System.out.print(currList.get(j) + " ");
      }
      System.out.println();
    }
  }

  // MOST STORE WATER
  public static int storeWater(ArrayList<Integer> height) {
    int maxWater = 0;
    for (int i = 0; i < height.size(); i++) {
      for (int j = i + 1; j < height.size(); j++) {
        int ht = Math.min(height.get(i), height.get(j));
        int width = j - 1;
        int currWater = ht * width;
        maxWater = Math.max(maxWater, currWater);
      }
    }
    return maxWater;
  }

  // MOST STORE WATER two pointer approach
  public static int storeWaterTwo(ArrayList<Integer> height) {
    int maxWater = 0;
    int lp = 0;
    int rp = height.size() - 1;

    while (lp < rp) {
      // calculate water area
      int ht = Math.min(height.get(lp), height.get(rp));
      int width = rp - lp;
      int currWater = ht * width;
      maxWater = Math.max(maxWater, currWater);

      // Update pointer
      if (height.get(lp) < height.get(rp)) {
        lp++;
      } else {
        rp--;
      }
    }
    return maxWater;
  }

  // merge sort
  public static void mergeSort(int arr[], int low, int high) {
    if (low >= high) {
      return;
    }
    int mid = (low + high) / 2;
    mergeSort(arr, low, mid);
    mergeSort(arr, mid + 1, high);
    merge(arr, low, mid, high);
  }

  public static void merge(int arr[], int low, int mid, int high) {
    int[] tempArr = new int[high - low + 1];
    int i = low;
    int j = mid + 1;
    int k = 0;
    while (i <= mid && j <= high) {
      if (arr[i] < arr[j]) {
        tempArr[k] = arr[i];
        i++;
      } else {
        tempArr[k] = arr[j];
        j++;
      }
      k++;
    }

    while (i <= mid) {
      tempArr[k++] = arr[i++];
    }
    while (j <= high) {
      tempArr[k++] = arr[j++];
    }

    for (k = 0, i = low; k < tempArr.length; k++, i++) {
      arr[i] = tempArr[k];
    }
  }

  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String args[]) {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(4);
    list.add(6);
    System.out.println(list);

    int arr[] = { 3, 12, 2, 7, 6, 4, 9, 1 };
    mergeSort(arr, 0, arr.length - 1);
    printArr(arr);

    // ArrayList<Integer> height = new ArrayList<>();
    // height.add(1);
    // height.add(8);
    // height.add(6);
    // height.add(2);
    // height.add(5);
    // height.add(4);
    // height.add(8);
    // height.add(3);
    // height.add(7);
    // System.out.println("Normal Approach: "+storeWater(height));
    // System.out.println("Two pointer approach: "+storeWaterTwo(height));

    // ArrayList<String> name1 = new ArrayList<>();
    // ArrayList<String> name2 = new ArrayList<>();
    // name1.add("Sujit");
    // name1.add("Thakur");
    // name2.add("Sujit");
    // name2.add("Thakur");
    // name2.add("Nigam");
    // System.out.println(name1);
    // System.out.println(name2);
    // addString(name1, name2);

    // reverseString(name);

    // list.add(2,10);
    // System.out.println(list);
    // printRev(list);
    // operation(list);
    // fintMaximum(list);
    // swapTwo(list);
    // removeEven(list);
    // System.out.println("Found at index: "+findElement(list,7));
    // removeDuplicate(list);
    // System.out.println(list);
    // System.out.println(list1);
    // System.out.println(list2);
    // interSection(list1, list2, list3);
    // System.out.println(list3);
    // sorting(list);
    // multiDimensional(list1, list2, list3);
  }
}