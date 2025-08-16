public class DivideConquer {

  // For printing array
  public static void printArr(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // merge sort
  public static void mergeSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }

    int mid = (si + ei) / 2; // si+(ei-si)/2;
    mergeSort(arr, si, mid);
    mergeSort(arr, mid + 1, ei);

    merge(arr, si, mid, ei);
  }

  public static void merge(int arr[], int si, int mid, int ei) {
    int tempArr[] = new int[ei - si + 1];
    int i = si;
    int j = mid + 1;
    int k = 0;

    while (i <= mid && j <= ei) {
      if (arr[i] > arr[j]) { // for ascending and decending
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
    while (j <= ei) {
      tempArr[k++] = arr[j++];
    }

    // Copy to original array
    for (k = 0, i = si; k < tempArr.length; k++, i++) {
      arr[i] = tempArr[k];
    }
  }

  // QUICK SORT
  public static void quickSort(int arr[], int si, int ei) {
    if (si >= ei) {
      return;
    }

    int pidx = partition(arr, si, ei);
    quickSort(arr, si, pidx - 1);
    quickSort(arr, pidx + 1, ei);
  }

  public static int partition(int arr[], int si, int ei) {
    int pivot = arr[ei];
    int i = si - 1;

    for (int j = si; j < ei; j++) {
      if (arr[j] <= pivot) {
        i++;
        // swap
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }
    i++;
    int temp = pivot;
    arr[ei] = arr[i];
    arr[i] = temp;
    return i;
  }

  public static void main(String[] args) {
    int arr[] = { 6, 3, 9, 5, 2, 8, 4, -2, -7 };
    System.out.println("Merge Sort: ");
    mergeSort(arr, 0, arr.length - 1);
    printArr(arr);
    System.out.println("Quick sort:");
    quickSort(arr, 0, arr.length - 1);
    printArr(arr);
  }
}