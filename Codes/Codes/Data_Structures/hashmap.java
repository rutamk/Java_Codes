package Codes.Data_Structures;
import java.util.*;

public class hashmap {
    public static void majorityElement(int num[]){ // in a given array find the elemts which have occured/have frequency of n/3 where n is the length of array
        HashMap<Integer,Integer> map = new HashMap<>(); 
        int n = num.length;
        for (int i = 0; i < n; i++) {
            if(map.containsKey(num[i])){
                map.put(num[i], map.get(num[i]) + 1);
            }
            else{
                map.put(num[i],1);
            }
        }
        for(int key : map.keySet()){
            if(map.get(key)> n/3 ){
                System.out.println(key);
            }
        }
    }
    public static int unionSize(int arr1[], int arr2[]){//determine the size of the union of 2 given arrays
        HashSet<Integer> set = new HashSet<>(); 
        int n1 = arr1.length;
        int n2 = arr2.length;

        for (int i = 0; i < n1; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < n2; i++) {
            set.add(arr2[i]);
        }

        return set.size();
    }
    public static int intersectionSize(int arr1[], int arr2[]){//determine the size of intersection of given 2 arrays
        HashSet<Integer> set = new HashSet<>(); 
        int count = 0;

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            if(set.contains(arr2[i])){
                count++;
                set.remove(arr2[i]);
            }
        }
        return count;
    }

    public static ArrayList<String> itinerary(HashMap<String,String> ticket){//find the itinerary route of cities based on 1 way tickets between cities given in a hashmap
        HashMap<String,String> revMap = new HashMap<>(); 
        String start = "";
        for(String key : ticket.keySet()){
            revMap.put(ticket.get(key), key);
        }

        for(String key : ticket.keySet()){//finding the start
            if(!revMap.containsKey(key)){
                start = key;
            }
        }
        ArrayList<String> list = new ArrayList<>();
        while(ticket.containsKey(start)){
            list.add(start);
            start = ticket.get(start);
        }
        list.add(start);//to add the last city
        return list;
    }
public static void main(String[] args) {
    //creation
    HashMap<String,Integer> map = new HashMap<>();
        //insertion
        map.put("rutam",8);
        map.put("alonso", 2);
        map.put("carlos", 0);

        System.out.println(map);

        map.put("rutam", 9);
        System.out.println(map);

        //searching
        if(map.containsKey("lance stroll")){
            System.out.println("lance idiot is still driving");
        }
        else{
            System.out.println("lance idiot finally left");
        }

        System.out.println(map.get("rutam"));
        System.out.println(map.get("max"));

        //iteration 1
        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.print(e.getKey()+ "->");
            System.out.println(e.getValue());
        }
        //iteration 2
        Set<String> keys = map.keySet();
        for(String key : keys){
            System.out.println(key + " " + map.get(key));
        } 

        //removing

        map.remove("alonso");
        System.out.println(map);

        int nums[] = {1,1,1,1,1,3,3,3,3,3,3,3,3,3};
        majorityElement(nums);

        int arr1[] = {7,3,9};
        int arr2[] = {6,3,9,2,9,4};
        System.out.println("size of union is " + unionSize(arr1, arr2));
        System.out.println("size of intersection is " + intersectionSize(arr1, arr2));

        HashMap<String, String> tickets = new HashMap<> ();
        tickets.put("Chennai", "Bengaluru"); 
        tickets.put("Mumbai", "Delhi"); 
        tickets.put("Goa","Chennai"); 
        tickets.put("Delhi","Goa");
        System.out.println(itinerary(tickets));
    }
}
