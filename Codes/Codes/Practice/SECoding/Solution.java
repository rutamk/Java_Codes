package SECoding;
import java.util.*;

public class Solution{
    public static int fib(int n){
        if(n == 1) return 0;
        if(n == 2) return 1;
        return fib(n-1) + fib(n-2);
    }
    public static String revStr(String str){
        char[] arr = str.toCharArray();
        int right = str.length()-1;
        for(int i = 0; i < str.length()/2; i++){
            arr[i] ^= arr[right];
            arr[right] ^= arr[i];
            arr[i] ^= arr[right--];
        }
        String ans = new String(arr);
        return ans;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> arrl = new ArrayList<>();
        System.out.println("Enter characters: ");
        for(int i = 0 ; i < 4 ; i++){
            String input = sc.nextLine();
            arrl.add(input.charAt(0));
        }
        System.out.println(fib(6));
        System.out.println(revStr("hello"));
    }
}

