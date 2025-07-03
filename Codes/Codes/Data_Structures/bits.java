package Codes.Data_Structures;
import java.util.*;
public class bits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
     /////////////////////////////GET BIT (AND)  //////////////////////////////// 
    
     System.out.print("Enter the number: ");
        int n = sc.nextInt();

        System.out.print("Enter the position : ");
        int p = sc.nextInt();
        
        int bitMask = 1<<p;

        // if ((bitMask & n) == 0) {
        //  System.out.println("Bit is 0");
        // } else{
        //     System.out.println("Bit is 1");
        // }
        
        /////////////////////////SET BIT(OR) ///////////////////////////////

        // int newNumber = (n | bitMask);
        // System.out.println("New number i "+ newNumber);

        ////////////////////////CLEAR BIT (NOT + AND)  ////////////////////////

        // int notOfBitMask = ~(bitMask);
        // int newNumber = notOfBitMask & n;
        // System.out.println("New number i "+newNumber);

        ////////////////////////UPDATE BIT  (SET or CLEAR) /////////////////////////
        
        System.out.println("1. UPDATE TO 1 \n2. UPDATE TO 0");
        int a = sc.nextInt();
        
        if (a==1) {
        int newNumber = (n | bitMask);
        System.out.println("New number i "+ newNumber);
        } 
        
        else {
        int notOfBitMask = ~(bitMask);
        int newNumber = notOfBitMask & n;
        System.out.println("New number i "+newNumber);
        }
    }    

}
