package Codes.Sorting;

import java.util.*;

public class selectionSort {
    public static void printArray(int arr[]) {
        System.out.print("Sorted array is ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");

        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int l = sc.nextInt();
        System.out.print("Enter the array: ");
        int arr[] = new int[l];
        for (int i = 0; i < l; i++) {
            arr[i] = sc.nextInt();
        }
        // selectionSort
        for (int i = 0; i < arr.length; i++) {
            int smallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[smallest])
                    smallest = j;
            }
            if (smallest != i) {
                arr[i] ^= arr[smallest];
                arr[smallest] ^= arr[i];
                arr[i] ^= arr[smallest];
            }
        }

        printArray(arr);

    }
}
