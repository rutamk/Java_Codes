package SECoding;

import java.util.Scanner;

public class PrimeFactors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int num = sc.nextInt();
        for (int i = num; i >= 2; i--) {
            if(PrimeNo.isPrime(i)){
                while(num % i == 0){
                    System.out.print(i +" ");
                    num /= i;
                }
            }
        }
    }
}
