/**
 * OOPS is using classes and objects
 * class is a user defined data type which has its data members and member functions
 * object is a run-time entity i.e. instance of a class. it will have the data members and its functions of the respective class
 * constructor is a special method which is invoked every time a new object is instantiated 
    Costructors have the same name as class or structure.
    Constructors don’t have a return type. (Not even void)
    Constructors are only called once, at object creation.
 
 * Polymorphism 
   1. Compile Time Polymorphism (Static) The polymorphism which is implemented at the compile time is known as compile-time polymorphism.
   Example - Method Overloading is a technique which allows you to have more than one function with the same function name but with different functionality.
   Method overloading can be possible on the following basis: 
    1. The type of the parameters passed to the function. 
    2. The number of parameters passed to the function.


   2. Runtime Polymorphism (Dynamic):Function overriding is an example of runtime polymorphism. Function overriding means when the child class contains the method 
   which is already present in the parent class. Hence, the child class overrides the method of the parent class. In case of function overriding, parent and child
   classes both contain the same function with a different definition. The call to the function is determined at runtime is known as runtime polymorphism.


 * Inheritance
   Inheritance is a key concept in object-oriented programming where a new class (subclass) can inherit properties and behaviors from an existing class (superclass).
   This allows for code reuse and the creation of hierarchical relationships among classes.

   Types of inheritance in Java include:

    Single Inheritance: ek parent ek child
    Multilevel Inheritance: ek parent fir ek child fir child ka bhi child ....
    Hierarchical Inheritance: ek parent multiple child
    Hybrid Inheritance: upar ka sab mix
    Multiple Inheritance (not supported in Java): ek child multiple parents (can be achieved using interfaces)

 */

package OOPS;
class Student{

    int roll;
    String name;

    //                    CONSTRUCTORS

    Student(){ //nonparameterised constructor
        System.out.println("nonparameterised Constructor called");
    }
    Student(String name, int roll){ //parameterised constructor
        this.name = name;
        this.roll = roll;
        System.out.println("parameterised Constructor called for "+this.name); //instance wala name
        this.roll++;
        System.out.println(roll); //parameter wala roll
        System.out.println(this.roll); //instance wala roll
    }
    Student(Student s1){
        System.out.print("copy Constructor called for "); //copy constructor
        this.roll = s1.roll;
        this.name = s1.name;
        System.out.println(this.name);
    }

    public void getInfo(){
        System.out.println(roll); //instance wala roll
        System.out.println(name); //instance wala name
    }

    public void changeRoll(){
        this.roll = 669;
    }
}


class Acc extends Accounts {
    public void printAge() {
        String name = null;
        String age = null;
        System.out.println(name +"'s age is: " + age);
    }

    private int pv = 2;
    public int getPV() {
        return pv;
    }
    private int setPV(int p) {
        this.pv = p;
        return pv;
    }
    public int getnewPV() {
        int p = this.pv;
        p++;
        return setPV(p);
    }
}


/*
 * ABSTRACTION  
 * abstract keyword use karna padta hai class ke liye
 * can have both abstract and non abstract methods
 * abstract class ka object nahi bana sakte but uske child ka bana sakte hai
 * abstract class me constructors aur static methods ho sakte hai 
 * final methods bhi ho sakte hai
 */
abstract class Animal {
    abstract void walk();
    void breathe() {
        System.out.println("This animal breathes air");
    }
    Animal() {
        System.out.println("You are about to create an Animal.");
    }
 }
 
 
 class Horse extends Animal {
    Horse() {
        System.out.println("Wow, you have created a Horse!");
    }
    void walk() {
        System.out.println("Horse walks on 4 legs");
    }
 }
 
 
 class Chicken extends Animal {
    Chicken() {
        System.out.println("Wow, you have created a Chicken!");
    }
    void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
 } 

/*
 * INTERFACES me interface keyword use karna padta hai
 * blue print jaisa hai
 * method define karneka interface me fir child me uska implementation daalneka
 * isko bhi instantiate nahi kar skte 
 * multiple inheritance support karega
 * variables are public static and final
 * methods are public and abstract
 * child class me sab method ka implementation daalna padega cumpulsory 
 */

 interface Animal1 {
    void walk();
 }
 
 
 class Horse1 implements Animal1 {
    public void walk() {
        System.out.println("Horse walks on 4 legs");
    }
 }
 
 
 class Chicken1 implements Animal1 {
    public void walk() {
        System.out.println("Chicken walks on 2 legs");
    }
 }
 

public class OOPS {

    public static void main(String[] args) {
        // Student s1 = new Student();
        // s1.roll = 69;
        // s1.name = "nigga";
        // s1.changeRoll();
        // s1.getInfo();

        // Student s2 = new Student();
        // s2.roll = 100;
        // s2.name = "giganiga";
        // s2.getInfo();

        // Student s1 = new Student("niga", 69);
        // s1.getInfo();
        // Student s2 = new Student("giganiga", 669);
        // s2.getInfo();
        // Student s3 = new Student();
        // Student s4 = new Student(s1);


        // bank.Accounts a1 = new Accounts();
        // a1.name = "niga";
        // a1.id = 69;

        // Acc A1 = new Acc();
        // System.out.println(A1.name);
        // A1.printAge();
        // //System.out.println(A1.pv); error
        // System.out.println("pv is " + A1.getPV()); //using getters for private variables
        // //A1.setPV(69); cant be used here but can be used in class
        // System.out.println(A1.getnewPV());
        // System.out.println("pv is " + A1.getPV()); //using getters for setting new value for private variables

        // Horse horse = new Horse();
        // horse.walk();
        // horse.breathe();


        Horse1 horse1 = new Horse1();
        horse1.walk();
    }
}