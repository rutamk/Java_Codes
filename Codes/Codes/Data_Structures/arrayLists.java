package Codes.Data_Structures;
import java.util.ArrayList;
import java.util.Collections;

public class arrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();

        //add elements
        list.add(0); 
        list.add(3);
        list.add(1);

        System.out.println(list);

        //get elements

        System.out.println(list.get(0)); // method 1
        int element = list.get(1);//method 2
        System.out.println(element);

        //add el in between

        list.add( 2, 7);
        System.out.println(list);

        //set element
        
        list.set(1, 9);
        System.out.println(list);

        //delete element

        list.remove(2);
        System.out.println(list);

        //size
        System.out.println(list.size()); // method 1
        int size = list.size();//method 2
        System.out.println(size);

        //loops

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //sorting
        Collections.sort(list);
        System.out.println(list);


    }

    
}
