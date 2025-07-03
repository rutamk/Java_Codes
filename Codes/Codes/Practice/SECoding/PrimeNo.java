package SECoding;

import java.util.Scanner;

// find the first n prime numbers
public class PrimeNo {
    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of prime numbers required: ");
        int n = sc.nextInt();
        int count = 0;
        int num = 2;
        while (count != n) {
            if (isPrime(num)) {
                System.out.print(num + ", ");
                count++;
            }
            num++;
        }
    }
}
