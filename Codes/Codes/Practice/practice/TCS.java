package practice;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TCS {
    public static void evenOccurence(int[] arr){
        Arrays.sort(arr);
        int count = 1;
        for(int i = 1 ; i < arr.length ; i++){
            if(arr[i]== arr[i-1]){
                count++;
            }
            else {
                if (count % 2 == 0) {
                    System.out.println(arr[i - 1]); // Print if even count
                }
                count = 1; // Reset count for the new number
            }
        }
        if(count%2 == 0){
            System.out.println(arr[arr.length - 1]);
        }

    }

    public static int flipBits(int n){
        String binary = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(char a : binary.toCharArray()){
            if(a == '0') sb.append('1');
            else sb.append('0');
        }
        return Integer.parseInt(sb.toString(),2);
    }

    public static void counter(String s){
        String vowel = "aeiou";
        String number = "0123456789";
        String special = "@#$%!*&^";
        int vowels = 0;
        int numbers = 0;
        int specials = 0;
        int consonants = 0;
        for(char a : s.toCharArray()){
            if(vowel.contains(Character.toString(a))) vowels++;
            else if(!number.contains(Character.toString(a)) && !special.contains(Character.toString(a))) consonants++;
            else if(number.contains(Character.toString(a))) numbers++;
            else specials++;
        }
        System.out.println(vowels + " " + consonants + " " + numbers + " " + specials);
    }
    
    public static void countLetter(String s, int p){
        Map<Character,Integer> mp = new HashMap<>();
        for(char a : s.toCharArray()){
            mp.put(a,mp.getOrDefault(a,0)+1);
        }
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Character,Integer> entry : mp.entrySet()){
            if(entry.getValue() >= p){
                sb.append(entry.getKey());
            }
        }
        char[] arr = sb.toString().toCharArray();
        Arrays.sort(arr);
        System.out.println(arr[0]);
    }

    public static void findCentury(int n){
        if(n%100 == 0) System.out.println(n/100);
        else System.out.println((n/100) + 1);
    }

    public static void itemValue(int N){
        int product = 1;
        int sum = 0;
        while(N>0){
            int digit = N%10;
            product *= digit;
            sum += digit;
            N /= 10;
        }
        int value = Math.abs(product-sum);
        System.out.println(value);
    }
    public static void upperToLowerVV(String s){
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char a : arr){
            if(Character.isLowerCase(a)) sb.append(Character.toUpperCase(a));
            else if(Character.isUpperCase(a)) sb.append(Character.toLowerCase(a));
            else sb.append(a);
        }
        System.out.println(sb.toString());
    }

    public static boolean threeDivisible(String s){
        int sum = 0;
        for(char digit : s.toCharArray()){
            sum += Integer.parseInt(Character.toString(digit));
        }
        if(sum%3 == 0) return true;
        else return false;
    }

    public static void frequency(int[] arr){
        Map<Integer,Integer> mp = new HashMap<>();
        for(int n : arr){
            mp.put(n,mp.getOrDefault(n,0)+1);
        }
        for(int i = 0 ; i < arr.length ; i++){
            arr[i] = mp.get(arr[i]);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        // int N = sc.nextInt();
        // int[] arr = new int[N];

        // for(int i  = 0 ; i < N ; i++){
        //     arr[i] = sc.nextInt();
        // }
        // sc.close();
        // evenOccurence(arr);
        // System.out.println(flipBits(N));
        // String s = sc.nextLine();
        // counter(s);
        // 
        // int n = sc.nextInt();
        // findCentury(n);
        // int[] arr = {1,2,2,6,1,1,1,6};
        // frequency(arr);
        String s = sc.nextLine();
        upperToLowerVV(s);
        sc.close();
    }
}
