package SECoding;

import java.util.Scanner;

public class Fibonacci {
    public static int fib(int num){
        if(num == 0) return 0;
        else if(num == 1) return 1;
        return fib(num-2)+fib(num-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length: ");
        int num = sc.nextInt();
        System.out.print("0 1 ");
        for (int i = 2; i < num; i++) {
            System.out.print(fib(i) + " ");
        }
    }
}
