import java.util.Scanner;

public class palindrome {
    public static void palin(int p){
        int lastDigit;
        int rev=0;
        int temp = p;
        while (p>0) {
             lastDigit = p%10;
             rev = rev*10+lastDigit;
             p=p/10;
        }
        if (rev == temp) {
            System.out.println(temp+" is Palindrome");
        }else{
            System.out.println(temp+" is Not palindrome");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int p = sc.nextInt();
        palin(p);
    }
}
