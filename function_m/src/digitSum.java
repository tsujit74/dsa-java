import java.util.Scanner;

public class digitSum {
    public static int sumDigit(int n){
        int lastDigit = 0;
        int sum = 0;
        while (n>0) {
            lastDigit = n%10;
            sum +=lastDigit;
            n/=10;
        }
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number:");
        int n = sc.nextInt();
        System.out.println("Sum of given digit: "+n+" = "+sumDigit(n));
    }
}
