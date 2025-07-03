package Codes.Sorting;

import java.util.*;

public class insertionSort {
    public static void printArray(int arr[]){
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
     for(int i=0;i<l;i++){
        arr[i] = sc.nextInt();
     }
       
       //insertionSort
     for (int i = 1; i < arr.length; i++) {
         int current = arr[i];
         int j = i-1;
         while (j>=0 && current < arr[j]) {
            arr[j+1] = arr[j];
            j--;
            }
         arr[j+1]= current;
        }
     printArray(arr);    
    }
}
