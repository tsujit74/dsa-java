import java.util.Scanner;

public class temp {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Scanner s = new Scanner((Readable) System.out);
        double t = sc.nextDouble();
        if (t>100) {
            System.out.println("You have a fever");
        }else{
            System.out.println("You don't have fever");
        }
    }
}
