import java.util.Scanner;

public class pattern8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int st = n;
        int sp = n-1;
        int num_of_line = 1;
        while (num_of_line<=n) {
            for(int i=0;i<sp;i++){
                System.out.print("  ");
            }
            
            if (num_of_line==1 || num_of_line==n) {
                for(int i=0;i<st;i++){
                    System.out.print("* ");
                }
            }else{
                System.out.print("* ");
                for(int i = 0;i<n-2;i++){
                    System.out.print("  ");
                }
                System.out.print("*");
            }
            System.out.println();
            sp--;
            num_of_line++;
        }
    }
}
