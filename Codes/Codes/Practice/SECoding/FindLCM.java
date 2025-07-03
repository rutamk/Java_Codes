package SECoding;

import java.util.Scanner;

public class FindLCM {
    public static int lcm(int num1, int num2){
        return Math.abs(num1*num2)/ FindGCD.gcd(num1, num2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter num1: ");
        int num1 = sc.nextInt();

        System.out.print("Enter num2: ");
        int num2 = sc.nextInt();

        System.out.println("LCM of " + num1 + " and " + num2 +" is " + lcm(num1, num2));
    }
}
