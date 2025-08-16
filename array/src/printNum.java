import java.util.Scanner;

public class printNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];

        for (int i=0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        System.out.println("PRINT");
        for (int i=0;i<a.length;i++){
            System.out.print(a[i]+" ");
        }
    }
}
