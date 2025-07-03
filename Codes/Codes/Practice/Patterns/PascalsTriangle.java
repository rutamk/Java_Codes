package Patterns;

import java.util.Scanner;

public class PascalsTriangle {
    public static int fact(int num){
        if(num == 1 || num == 0) return 1;
        return num*fact(num-1);
    }
    public static void main(String[] args) {
        // System.out.println(fact(5));
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        for (int i = 0; i < rows; i++) {
            for (int j = 1; j <= rows-i ; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print(fact(i)/(fact(j)*fact((i-j))) + " ");
            }
            System.out.println();
        }
    }
}
