package SECoding;

import java.util.Scanner;

public class FindGCD {
    public static int gcd(int num1, int num2) {
        if (num1 < num2) {
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
        }
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return num1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();

        System.out.println("GCD of " + num1 + " and " + num2 +" is " + gcd(num1, num2));
    }
}
