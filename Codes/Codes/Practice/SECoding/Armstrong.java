package SECoding;

import java.util.Scanner;

public class Armstrong {

    public static int countNumLength(int num) {
        if (num < 0) num = -num;
        if (num < 10) return 1; 
        return 1 + countNumLength(num / 10); 
    }

    public static boolean isArmstrong(int num) {
        int originalNum = num;
        int length = countNumLength(num);
        int sum = 0;
        while (num > 0) {
            int digit = num % 10;
            sum += PowerOf.pow(digit, length);
            num /= 10;
        }
        return originalNum == sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int num = sc.nextInt();

        System.out.println(num + " is " + (isArmstrong(num) ? "" : "not ") + "an Armstrong number.");
    }
}
