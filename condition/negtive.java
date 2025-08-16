import java.util.Scanner;

class negtive{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n==0) {
            System.out.println("Number is 0");
        }else if (n>0) {
            System.out.println("Number is positive");
        }else{
            System.out.println("Number is negative");
        }
    }
}