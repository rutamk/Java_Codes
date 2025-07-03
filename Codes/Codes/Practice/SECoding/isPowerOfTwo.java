package SECoding;

import java.util.Scanner;

public class isPowerOfTwo {
    public static boolean isPowOfTwo(int num) {
        while (num != 1) {
            if (num % 2 != 0)
                return false;
            num /= 2;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println(num + " is " + (isPowOfTwo(num) ? "a " : "not a ") + "power of 2.");
    }
}
