package Codes.Data_Structures;
import java.util.*;
public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data < val){
            root.right = insert(root.right, val);
        }
        else{
            root.left = insert(root.left,val);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root == null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static boolean search(Node root, int key){
        if(root==null){
            return false;
        }
        if(root.data < key){
            return search(root.right, key);
        }
        else if(root.data == key){
            return true;
        }
        else{
            return search(root.left, key);
        }
        
    }
    public static Node delete(Node root,  int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }
        else if(root.data == val){  
            //case 1: no children(leaf)
            if(root.left == null && root.right == null){
                return null;
            }            
            //case 2: 1 children
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            //case 3: 2 children  [inorder succesor is always the left most node in the right subtree and it has 0 or 1 child]
            Node IS = inorderSuccesor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node inorderSuccesor(Node root){
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
    public static void printInRange(Node root,int x , int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){
            printInRange(root.left , x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if (root.data >= y){
            printInRange(root.left, x, y);
        }
        else{
            printInRange(root.right, x, y);
        }
    }
    public static void printPath(ArrayList<Integer> path){
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ->");
        }
        System.out.println();
    }
    public static void printRoot2Path(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }

        path.add(root.data);

        if(root.left == null && root.right == null){
            printPath(path);
        }
        else{
            printRoot2Path(root.left, path);
            printRoot2Path(root.right, path);        
        }
        path.remove(path.size()-1);
    }
    public static void main(String[] args) {
        int values[] = {8,5,3,6,10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.err.println();

        if(search(root, 4)){
            System.out.println("found");
        }
        else{
            System.out.println("not found");
        }
        delete(root, 5);
        inorder(root);
        System.out.println();

       printInRange(root, 4, 10);
       System.out.println();

       printRoot2Path(root, new ArrayList<>());
    }
    

    
}
