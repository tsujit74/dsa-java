public class sorting {

    // bubble sort
    public static void bubbleSort(int arr[]) {
        System.out.println("Bubble sort");
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // selection sort //5,4,1,3,2
    public static void selectionSort(int arr[]) {
        System.out.print("Selection sort: ");
        for (int i = 0; i < arr.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minPos] < arr[j]) {
                    minPos = j;
                }
            }
            int temp = arr[minPos];
            arr[minPos] = arr[i];
            arr[i] = temp;
        }
    }

    // Insertion sort //5,4,1,3,2
    public static void insertionSort(int arr[]) {
        System.out.print("Insertion sort: ");
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            arr[prev + 1] = curr;
        }
    }

    // COunting sort 5,4,1,3,2
    public static void countingSort(int arr[]) {
        System.out.print("Counting Sort: ");
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            largest = Math.max(largest, arr[i]);
        }
        System.out.println(largest);

        int count[] = new int[largest + 1];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;

        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    // reverse Counting
    public static void reverseCountingSort(int arr[]) {
        System.out.println("count");
        int n = arr.length;
        int max_ele = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max_ele) {
                max_ele = arr[i];
            }
        }

        int freq[] = new int[max_ele + 1];
        for (int i = 0; i < n; i++) {
            freq[arr[i]] += 1;
        }

        for (int i = max_ele; i >= 0; i--) {
            while (freq[i] > 0) {
                System.out.print(i + " ");
                freq[i] -= 1;
            }
        }
    }

    // printing array
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 5, 4, 1, 3, 2 };
        bubbleSort(arr);
        // Arrays.sort(arr, 0, 3);
        printArr(arr);
    }
}
