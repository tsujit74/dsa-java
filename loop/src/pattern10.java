import java.util.Scanner;

public class pattern10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n - 1;
        int st = 1;
        int a = 1;
        int num_of_line = 1;
        //Number pyramid pattern
        while (num_of_line <= n) {
            for (int i = 0; i < sp; i++) {
                System.out.print(" ");
            }
            for(int i =1;i<=st;i++){
                System.out.print(a+ " ");
            }
            System.out.println();
            sp--;
            st++;
            a++;
            num_of_line++;
        }
    }
}
