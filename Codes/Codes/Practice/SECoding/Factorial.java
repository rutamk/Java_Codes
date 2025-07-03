package SECoding;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {
    // public static int fact(int num){
    //     if(num == 1 || num == 0) return 1;
    //     return num*fact(num-1);
    // }
     public static BigInteger fact(int num) {
        // Base case: if num is 0 or 1, return 1 as BigInteger
        if (num == 1 || num == 0) {
            return BigInteger.ONE;
        }
        // Recursive call using BigInteger
        return BigInteger.valueOf(num).multiply(fact(num - 1));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        System.out.println(fact(num));
    }
}
