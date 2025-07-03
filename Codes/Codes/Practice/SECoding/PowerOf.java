package SECoding;

import java.util.Scanner;

public class PowerOf {
    public static int pow(int base, int power) {
        if (power == 0) return 1;
        if (power == 1) return base;
        return base *  pow(base, power - 1);
    }

    // public static BigInteger pow(int base, int power) {
    //     // Base cases
    //     if (power == 0) return BigInteger.ONE;
    //     if (power == 1) return BigInteger.valueOf(base);
    //     // Recursive computation
    //     return BigInteger.valueOf(base).multiply(pow(base, power - 1));
    // }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter base: ");
        int base = sc.nextInt();

        System.out.print("Enter power: ");
        int power = sc.nextInt();

        System.out.println(base + "^" + power + "= " + pow(base, power));

    }
}
