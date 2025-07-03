package practice;

public class last_length {

    public  static int lengthOflast(String s){
        int count = 0;
        s = s.strip();
        int length = s.length();
        for(int i = length-1 ; i >= 0 ;i--){
            if(s.charAt(i) != ' '){
                count++;
            }
            else{
                break;
            }
        }return count;
    }
    public static void main(String[] args) {
        String s = "   gwetrg ewtrg tregetr   ";
        System.out.println(lengthOflast("Hello World    "));
        System.out.println(s.strip());
    }
}
