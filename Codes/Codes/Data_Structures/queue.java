package Codes.Data_Structures;

public class queue{
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            next = null;
        }
    }
    static class Queue{
        Node head = null;
        Node tail = null;

        public boolean isEmpty(){
            return head == null && tail == null;
        }

        public int add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head = newNode;
                tail = head;
                return tail.data;
            }
            tail.next = newNode;
            tail = newNode;
            return tail.data;
        }

        public int remove(){
            if(isEmpty()){
                System.out.println("Queue is empty");
                return -1;
            }            
            int removed = head.data;
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return removed;
        }

        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            return head.data;
        }
    }
    
    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.remove());
        }
    }
}


