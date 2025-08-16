public class arrayBasic {

    // Rotation
    public static void rotation(int arr1[]) {
        System.out.print("Original Array: ");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        int n = 3;
        for (int i = 1; i <= n; i++) {
            int last = arr1[0];
            for (int j = 0; j < arr1.length - 1; j++) {
                arr1[j] = arr1[j + 1];
            }
            arr1[arr1.length - 1] = last;
        }
    }

    // Insert
    public static void insertElement(int arr[]) {
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");

        int ind = 2;
        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            arr[ind] = value;
        }
    }

    // Delete
    public static void deleteElement(int arr[]) {
        System.out.print("Original Array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(" ");
        int ind = 3;
        for (int i = ind; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
    }

    // linear search
    public static int linearSearch(int arr[]) {
        System.out.print("Linear Search: ");
        int value = 10;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Binary search
    public static int binarySearch(int arr[]) {
        int val = 10;
        int st = 0;
        int lt = arr.length - 1;
        System.out.print("Binary Search: ");
        while (st <= lt) {
            int mid = (st + lt) / 2;
            if (arr[mid] == val) {
                return mid;
            }
            if (arr[mid] < val) {
                st += 1;
            }
            if (arr[mid] > val) {
                lt = mid - 1;
            }
        }
        return -1;
    }

    // merge two array//1,2,3,4,5 6,7,8,9,10
    public static void mergeTwoArray(int arr1[], int arr2[]) {
        for(int i = 0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
        for(int i = 0;i<arr2.length;i++){
            System.out.print(arr2[i]+" ");
        }
        System.out.println();
        int l1 = arr1.length;
        int l2 = arr2.length;
        int l = l1+l2;
        System.out.println(l1+" "+l2+" "+l);
        int arr[] = new int[l];
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        for(int i = 0;i<arr2.length;i++){
            arr[l1+i] = arr2[i];
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void printArr(int arr1[]) {
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 20, 30, 40, 50};
        int arr2[] = { 80, 90, 100, 120 };
        rotation(arr1);
        printArr(arr1);
        //mergeTwoArray(arr1, arr2);
        // System.out.println("at index "+linearSearch(arr));
        // System.out.println("at index "+binarySearch(arr));
    }
}
