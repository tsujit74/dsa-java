import java.util.Scanner;

public class acceptEven {
    public static boolean even(int a){
        if (a%2==0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number: ");
        int a = sc.nextInt();
        System.out.println(even(a));
        if (a==0) {
            System.out.println("Given number is 0");
        }else if (even(a)) {
            System.out.println("Given number is EVEN");
        }else{
            System.out.println("Given number is ODD");
        }

        if (even(12)) {
            System.out.println("function is fine.");
        }else{
            System.out.println("some error in function.");
        }
    }
}
