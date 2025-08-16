import java.util.Scanner;

public class pattern4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int st = n;
        //int sp = 0;
        int num_of_line = 1;

        while (num_of_line<=n) {
            for(int i= 0;i<st;i++){
                System.out.print("*");
            }

            System.out.println();
            st--;
            num_of_line++;
        }
    }
}
