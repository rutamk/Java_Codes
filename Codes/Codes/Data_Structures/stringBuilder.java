package Codes.Data_Structures;

public class stringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Rutam");
        System.out.println(sb);

        System.out.println(sb.charAt(0));

        sb.setCharAt(0, 'u');
        System.out.println(sb);

        sb.insert(2, 't');
        System.out.println(sb);

        sb.delete(0, 1);

        System.out.println(sb);

        for (int i = 1; i <= sb.length() / 2; i++) {
            int front = (i - 1);
            int back = sb.length() - i;

            char frontChar = sb.charAt(front);
            char backChar = sb.charAt(back);

            sb.setCharAt(front, backChar);
            sb.setCharAt(back, frontChar);
        }
        System.out.println(sb);

    }

}
