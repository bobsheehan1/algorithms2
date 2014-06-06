package org.sheehan.algorithm;

/**
 * Created by bob on 5/31/14.
 */
public class ListImpl <T>{
    class Node <T> {
        T value;
        Node next;

        public Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    Node head;

    public ListImpl() {
        this.head = null;
    }


   public void append (T value) {
       Node<T> newNode = new Node<>(value);
       if (this.head == null)
           this.head = newNode;
       else {
           Node n = this.head;
           while (n.next != null) {
               n = n.next;
           }
           n.next = newNode;

       }
   }

    //brute force
    public void reverse1() {
        Node n = this.head;
        while (n.next != null) {
            n = n.next;
        }

        Node tail = n;

        n = this.head;
        Node prev = null;
        while (n.next != null) {
            n = n.next;
            Node n2 = this.head;
            while (n2.next != null) {
                prev = n2;
                n2 = n2.next;
            }

            n2.next = prev;
            prev.next = null;
        }

        head = tail;
    }

    public  void reverse2() {
        Node n = this.head;
        Node A = null;
        Node B = n;
        Node C = n.next;
        while (n.next != null) {
            n = n.next;
            B.next = A;
            A = B;
            B = C;
            C = C.next;
        }

        B.next = A;
        A = B;

        this.head = A;
    }

    public void print(){
        Node n = this.head;
        while (n != null){
            System.out.print (n.value + " ");
            n = n.next;
        }

        System.out.println();
    }

}
