import java.util.Scanner;

public class binary {
    public static void binToDec(int binNum) {
        int pow = 0;
        int dec = 0;
        int myNum = binNum;
        while (binNum > 0) {
            int lastDigit = binNum % 10;
            dec = dec + (lastDigit * (int) Math.pow(2, pow));
            pow++;
            binNum = binNum / 10;
        }
        System.out.println("Decimal of " + myNum + " = " + dec);
    }

    public static void decToBin(int n) {
        int pow = 0;
        int bin = 0;
        int myNum = n;
        while (n > 0) {
            int rem = n % 2;
            bin = bin + (rem * (int) Math.pow(10, pow));
            pow++;
            n = n / 2;
        }
        System.out.println("Binary of " + myNum + " = " + bin);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the binary number: ");
        int b = sc.nextInt();
        binToDec(b);
        System.out.println("Enter the decimal number: ");
        int n = sc.nextInt();
        decToBin(n);
    }
}
