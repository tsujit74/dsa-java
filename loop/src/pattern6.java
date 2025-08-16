import java.util.Scanner;

public class pattern6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int st = 1;
        int sp = 2 * n - 2;
        int num_of_line = 1;
        while (num_of_line <= 2 * n) {
            for (int i = 0; i < st; i++) {
                System.out.print("* ");
            }
            for (int i = 0; i < sp; i++) {
                System.out.print("  ");
            }
            for (int i = 0; i < st; i++) {
                System.out.print(" *");
            }
            if (num_of_line < n) {
                st++;
                sp = sp-2;
            } else if (num_of_line > n) {
                st--;
                sp = sp+2;
            }
            System.out.println();
            num_of_line++;
        }

    }
}
