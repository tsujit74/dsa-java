import java.util.Scanner;

public class pattern9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n - 1;
        int st = 1;
        int num_of_line = 1;
        //Daimond
        while (num_of_line <= n*2) {
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            if (num_of_line < n) {
                sp--;
                st += 2;
            } else  {
                sp++;
                st -= 2;
            }
            System.out.println();
            num_of_line++;
        }
    }
}
