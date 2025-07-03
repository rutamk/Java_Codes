package Codes.Sorting;
import java.util.*;

public class bubbleSort {
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
       //time complexity = O(n^2)
     for (int i = 0; i < arr.length-1; i++) {
        for (int j = 0; j < arr.length-i-1; j++) {
            if(arr[j]>arr[j+1]){
                //swap
                int temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
            
        }
        
    }

printArray(arr);
    
}
}
