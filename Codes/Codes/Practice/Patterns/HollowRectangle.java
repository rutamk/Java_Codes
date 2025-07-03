package Patterns;

import java.util.*;

public class HollowRectangle {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        System.out.println();

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        //Hollow rectangle
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

}