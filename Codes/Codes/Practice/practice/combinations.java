package practice;

public class combinations {
    public static void combinations(String str, String perm){
        if(perm.length() == str.length()){
            System.out.println(perm);
            return;
        }
        for(int i = 0; i < str.length() ; i++){
            char currChar = str.charAt(i);
            combinations(str, perm + currChar);
        }
    }
    public static void main(String[] args) {
        String str = "Rutam";
        combinations(str,"");
    }
}
