package practice;
public class recursion {
    //sum of n natural nums
    public static void sumNumb(int end, int start, int sum) {
        if (start==end) {
        sum = sum+start;  
        System.out.println(sum);      
        return;
        }
        else{
            sum += start;
            sumNumb(end, start+1, sum);
        }            
    }
    public static int sumNum(int n) {
        if(n == 0){
            return 0;
        }
        return n + sumNum(n-1);
    }
    //fibonacci
    public static void fibonacci(int a, int b, int n ) {
        if (n==2) { //we are already printing the starting 0 1 
            return;
        }
        if (a==0) {
            System.out.print("0 1 ");           
        }
        int c = a+b; 
        System.out.print( c + " " );
        fibonacci(b, c, n-1);
    }
    //x^n stack height = n
    public static int xPowerN(int x, int N) {
        if(N==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        int xPowerNM1 = xPowerN(x, N-1);
        int xPowerN = x * xPowerNM1;
        return xPowerN;
    }
    public static int xPowern(int x, int N) {
        if(x == 0) return 0;
        if(N == 0) return 1;
        if(N == 1) return x;
        return x * xPowern(x, N-1);
    }
    // x^n stack height = logn
    public static int xPowerNLogN(int x, int N) {
        if(N==0){
            return 1;
        }
        if(x==0){
            return 0;
        }
        if(N%2==0){ // N is even
            return xPowerNLogN(x, N/2) * xPowerNLogN(x, N/2);
        }
        else{ //N is odd
            return xPowerNLogN(x, N/2)* xPowerNLogN(x, N/2) * x;
        }
    }
    // Reverse a string
    public static void revString(String s, int index) {
        if (index==0) {
            System.out.println(s.charAt(index));
            return;
        }
        System.out.print(s.charAt(index));
        revString(s, index-1);
    }
    // first and last occurence of char in string
     public static int first = -1;
     public static int last = -1;
     public static void firstAndLastOccurence(String str, int idx, char element) {
        if(idx==str.length()){
         System.out.println("first occurence is at index "+first+" and last occurence at index "+last);
          return;
        }
        char currChar = str.charAt(idx);
        if(currChar==element){
            if(first==-1){
                first=idx;
            }
            else{
                last = idx;
            }
        }
        firstAndLastOccurence(str, idx+1, element);
    }
    // check if an array is sorted (strictly increasing)
    public static boolean sortedArray(int arr[],int idx ) {
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]<arr[idx+1]){
            return sortedArray(arr, idx+1);
        }
        else{
            return false;
        }
    }
    //remove duplicate characters from string
    public static boolean[] map = new boolean[26];
    public static void removeDuplicates (String str, int idx, String newString) {
    if (idx == str.length()) {
    System.out.println(newString);
    return;
    }
    char currChar = str. charAt (idx);
    if (map [currChar - 'a']) {
    removeDuplicates(str, idx+1, newString) ;
    }
    else {
    newString += currChar;
    map [currChar - 'a'] = true;
    removeDuplicates (str, idx+1, newString);
    }
}
    // print all the subsequences
    public static void subsequences(String str, int idx, String newString) {
        if (idx == str.length()) {
            System.out.println(newString);
            return;
        }
        char currChar = str.charAt(idx);
        // to be
        subsequences(str, idx + 1, newString + currChar);
        // or not to be
        subsequences(str, idx + 1, newString);
    }

    public static void main(String[] args) {
      sumNumb(5, 1, 0);

      fibonacci(0, 1, 10);
      
      System.out.println("\n" + xPowerN(2, 5));
      System.out.println( + xPowerNLogN(2, 5));
      
      String s = "RutaM";
      revString(s, s.length()-1);
      
      firstAndLastOccurence("abaacdaefaah", 0, 'a');
      
      int arr[]= {3,2,3,4,5};
      System.out.println(sortedArray(arr, 0));

      String str = "abbccda";
      removeDuplicates(str,0,"");

      String stri = "abc"; 
      subsequences (stri, 0,"");
      System.out.println(sumNum(4));
    }   
}
