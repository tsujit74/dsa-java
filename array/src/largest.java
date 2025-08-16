import java.util.Scanner;

public class largest {
    public static void getLargest(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size: ");
        int n = sc.nextInt();
        int a[] = new int[n];

        System.out.println("Enter array element: ");
        for (int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("PRINT ELEMENT");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }

        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = 0;i < a.length;i++){
            if (largest < a[i]){
                largest = a[i];
            }
            if (smallest > a[i]){
                smallest = a[i];
            }
        }
        System.out.println("\nSmallest: "+ smallest);
        System.out.println(("Largest: "+ largest));
    }
    public static void main(String[] args) {
        getLargest();
    }
}
