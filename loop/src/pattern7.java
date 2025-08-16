import java.util.Scanner;

public class pattern7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n - 1;
        int st = n;
        int num_of_line = 1;
        while (num_of_line <= n) {
            for (int i = 1; i <= sp; i++) {
                System.out.print(" ");
            }
            for (int i = 1; i <= st; i++) {
                System.out.print("*");
            }
            System.out.println();
            sp--;
            num_of_line++;
        }
    }
}
