import java.util.Scanner;

class example {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sp = n - 1;
        int st = 1;
        int num_of_line = 1;
        while (num_of_line <= n) {
            for (int i = 0; i < sp; i++) {
                System.out.print("*+");
            }
            int curnt_num = num_of_line;
            for (int i = 1; i <= st; i++) {
                System.out.print(curnt_num+" ");
                if (i > st / 2) {
                    curnt_num++;
                } else {
                    curnt_num--;
                }
            }
            System.out.println();
            sp--;
            st += 2;
            num_of_line++;
        }
    }
}