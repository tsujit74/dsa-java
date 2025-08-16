import java.util.Scanner;

public class pattern5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int st = n;
        int sp = n - 2;
        int num_of_line = 1;
        while (num_of_line <= n) {
            if (num_of_line == 1 || num_of_line == n) {
                for (int i = 0; i < st; i++) {
                    System.out.print("* ");
                }
            } else {
                System.out.print("*");
                for (int i = 0; i < sp; i++) {
                    System.out.print("  ");
                }
                System.out.print(" *");
            }

            System.out.println();
            num_of_line++;
        }
    }
}
