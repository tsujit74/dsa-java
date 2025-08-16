import java.util.Scanner;

public class sumeven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        int evenSum = 0;
        int oddSum = 0;

        do {
            System.out.print("Enter The number: ");
            int n = sc.nextInt();
            if (n % 2 == 0) {
                evenSum += n;
            } else {
                oddSum += n;
            }
            System.out.println("YOu want to contiune press 1? for close press 0");
            choice = sc.nextInt();
        } while (choice == 1);
        System.out.println("Even Sum= " + evenSum);
        System.out.println("Odd Sum= " + oddSum);
    }
}
