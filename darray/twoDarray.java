import java.util.Scanner;

public class twoDarray {

    public static boolean search(int arr[][], int key) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == key) {
                    System.out.println("Found at cell: (" + i + "," + j + ")");
                    return true;
                }
            }
        }
        System.out.println(key + " Not found");
        return false;
    }

    public static void largest(int arr[][]) {
        int l = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] > l) {
                    l = arr[i][j];
                }
                if (arr[i][j] < s) {
                    s = arr[i][j];
                }
            }
        }
        System.out.println("Largest Value: " + l);
        System.out.println("Smallest Value: " + s);
    }

    public static void sumArray(int arr[][]) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                sum = sum + arr[i][j];
            }
        }
        System.out.println("Sum of array value: " + sum);
    }

    public static int diognalSum(int arr[][]) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (i == j || i + j == arr.length - 1) {
                    sum += arr[i][j];
                }
            }
        }

        return sum;
    }

    // 1,2,3,4
    // 5,6,7,8
    // 1,2,3,4
    // 5,6,7,8

    public static void spiralArray(int arr[][]) {
        int sr = 0;
        int sc = 0;
        int er = arr.length - 1;
        int ec = arr.length - 1;

        while (sr <= er && sc <= ec) {
            // top
            for (int j = sc; j <= ec; j++) {
                System.out.print(arr[sr][j] + " ");
            }
            // right
            for (int i = sr + 1; i <= er; i++) {
                System.out.print(arr[i][ec] + " ");
            }
            // bottom
            for (int j = ec - 1; j >= sc; j--) {
                System.out.print(arr[er][j] + " ");
            }
            // left
            for (int i = er - 1; i >= sr + 1; i--) {
                System.out.print(arr[i][sc] + " ");
            }
            sc++;
            sr++;
            ec--;
            er--;

        }
        System.out.println();
    }

    public static int countElement(int arr[][], int key) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (key == arr[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int sumRow(int arr[][], int row) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i == row) {
                for (int j = 0; j < arr[0].length; j++) {
                    sum += arr[i][j];
                }
            } else {
                System.out.println("Row Not exist!");
                return 0;
            }
        }
        return sum;
    }

    public static void tranposeMatrix(int arr[][]) {
        System.out.println("TRANSPOSE");
        for(int i=0;i<arr[0].length;i++){
            for(int j=0;j<arr.length;j++){
                System.out.print(arr[j][i]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
         int arr[][] = { { 1, 2, 3,4 }, { 5, 6, 7,8 }, { 9,1,1,2 } ,{3,4,5,6},{1,1,1,1}};
        //int[][] arr = { { 11, 12, 13 }, { 21, 22, 23 } };
        System.out.println("Print array");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }

        // search(arr, 5);
        // largest(arr);
        // sumArray(arr);
        // System.out.println("SUm of diagonal: " + diognalSum(arr));
        // spiralArray(arr);
        // System.out.println("Element occur at " + countElement(arr, 2)+" Times.");
        // System.out.println("Sum of row:" + sumRow(arr,3));
        tranposeMatrix(arr);
    }
}
