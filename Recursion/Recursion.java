class Recursion {
  public static void printDec(int n) {
    if (n == 1) {
      System.out.println(1);
      return;
    }
    System.out.print(n + " ");
    printDec(n - 1);
  }

  // Factorial
  public static int recursionFact(int n) {
    if (n == 1) {
      return 1;
    }
    int f = n * recursionFact(n - 1);
    return f;
  }

  // Sum of natural number

  public static int recursionSum(int n) {
    if (n == 1) {
      return 1;
    }
    int s = 0;
    s = n + recursionSum(n - 1);
    return s;
  }

  // fiboncci
  public static int fib(int n) {
    if (n == 0 || n == 1) {
      return n;
    }

    int fnm1 = fib(n - 1);
    int fnm2 = fib(n - 2);
    int fn = fnm1 + fnm2;
    return fn;
  }

  // Array is sorted or not
  public static boolean isSorted(int arr[], int i) {
    if (i == arr.length - 1) {
      return true;
    }
    if (arr[i] > arr[i + 1]) {
      return false;
    }
    return isSorted(arr, i + 1);
  }

  // FIRST occurernce element in array
  public static int firstOccurence(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }
    if (arr[i] == key) {
      return i;
    }
    return firstOccurence(arr, key, i + 1);
  }

  // LAst occurence element in array;
  public static int lastOccurence(int arr[], int key, int i) {
    if (i == arr.length) {
      return -1;
    }
    int isFound = lastOccurence(arr, key, i + 1);
    if (isFound == -1 && arr[i] == key) {
      return i;
    }
    return isFound;
  }

  // Find x to the power n
  public static int power(int x, int n) {
    if (n == 0) {
      return 1;
    }
    return x * power(x, n - 1);
  }

  // Optimized method

  public static int powerOptimized(int x, int n) {
    if (n == 0) {
      return 1;
    }
    int halfPower = powerOptimized(x, n / 2);
    int halfPowerSq = halfPower * halfPower;
    if (n % 2 != 0) {
      halfPowerSq = x * halfPowerSq;
    }
    return halfPowerSq;
  }

  // tiling problem
  public static int tilingProblem(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    // Verticle
    int fnm1 = tilingProblem(n - 1);
    // Horizontol
    int fnm2 = tilingProblem(n - 2);

    int totalWays = fnm1 + fnm2;
    return totalWays;
  }

  // Remove Duplication Array
  public static void removeDuplicate(String str, int idx, StringBuilder newStr, boolean map[]) {
    if (idx == str.length()) {
      System.out.println(newStr);
      return;
    }
    char curntChar = str.charAt(idx);
    if (map[curntChar - 'a'] == true) {
      removeDuplicate(str, idx + 1, newStr, map);
    } else {
      map[curntChar - 'a'] = true;
      removeDuplicate(str, idx + 1, newStr.append(curntChar), map);
    }
  }

  // Frienda paring problem
  public static int friendsPairing(int n) {
    if (n == 1 || n == 2) {
      return n;
    }
    // //single
    // int fnm1 = friendsPairing(n-1);
    // //pair
    // int fnm2 = friendsPairing(n-2);
    // int pairWays = (n-1)*fnm2;

    // int totalWays = fnm1 + pairWays;
    // return totalWays;

    return friendsPairing(n - 1) + (n - 1) * friendsPairing(n - 2);
  }

  // Binary String Problem //Without Consecutive 1 ex = "110"
  public static void printBinString(int n, int lastPlace, String str) {
    if (n == 0) {
      System.out.println(str);
      return;
    }
    printBinString(n - 1, 0, str + "0");
    if (lastPlace == 0) {
      printBinString(n - 1, 1, str + "1");
    }
  }

  // Assignment
  public static void allIndex(int arr[], int key, int i) {
    if (i == arr.length) {
      return;
    }
    if (arr[i] == key) {
      System.out.print(i + " ");
    }
    allIndex(arr, key, i + 1);
  }

  // 2003 output as two zero zero three

  static String digits[] = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

  public static void printDigit(int n) {
    if (n == 0) {
      return;
    }
    int lastDigit = n % 10;
    printDigit(n / 10);
    System.out.print(digits[lastDigit] + " ");
  }

  // Length of String
  public static int lengthString(String str, int i) {
    if (i == str.length()) {
      return i;
    }
    return lengthString(str, i + 1);
  }

  public static String subString(String str, int i, String newStr) {
    if (i == str.length()) {
      return newStr;
    }
    char stStr = str.charAt(i);
    System.out.println(newStr + stStr);
    return subString(str, i + 1, newStr+stStr);
  }

  public static void main(String[] args) {
    // int n = 4;
    // int arr[] = { 3, 2, 4, 5, 6, 2, 7, 2, 2 };
    String str = "abcab";
    // allIndex(arr, 2, 0);
    // printDigit(10001);
    // System.out.println("\nlength of string: " + lengthString(str, 0));
    System.out.println(subString(str, 0, ""));
    // printDec(n);
    // System.out.println(recursionFact(n));
    // System.out.println(recursionSum(n));
    // System.out.println(fib(n));
    // System.out.println(isSorted(arr, 0));
    // System.out.println("first Occure at index " + firstOccurence(arr, 5, 0));
    // System.out.println("Last Occurence at index " + lastOccurence(arr, 5, 0));
    // System.out.println("power " + power(2, 5));
    // System.out.println("Optimized Power " + powerOptimized(2, 5));
    // System.out.println("Tiling problem 2*n: " + tilingProblem(n));
    // System.out.print("Remove duplicates from " + str + " : ");
    // removeDuplicate(str, 0, new StringBuilder(""), new boolean[26]);
    // System.out.println("Friends Pair: " + friendsPairing(3));
    // System.out.print("Binary String problem:\n");
    // printBinString(3, 0, "");
  }
}