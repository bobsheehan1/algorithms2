package org.sheehan.algorithm.data_structures;

import java.util.*;

/**
 * Created by bob on 5/31/14.
 */
public class ListImpl <T extends Comparable<T>> implements List<T> {


    @Override
    public Iterator<T> iterator() {
        return new MyListIterator<T>(this);
    }


    public class MyListIterator<T extends Comparable<T>> implements Iterator<T> {
        Node<T> current;

        public MyListIterator(ListImpl<T> nodes) {
            current= nodes.head;

        }

        @Override
        public boolean hasNext() {
            return this.current != null;
        }

        @Override
        public T next() {
            T value = this.current.value;
            this.current = this.current.next;
            return value;
        }
    }

    public class Node <T> {
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


   @Override
   public void append(T value) {
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
    @Override
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

    // scaffold approach O(n)
    @Override
    public  void reverse2() {
        Node n = this.head;
        Node A = null;
        Node B = n;
        Node C = n.next;
        while (n.next != null) {
            n = n.next; // iterate
            B.next = A; //reversal step

            // move the scaffold
            A = B;
            B = C;
            C = C.next;
        }

        B.next = A; //reversal
        A = B; // move the scaffold

        this.head = A; // don't forget to set the head !!!
    }

    @Override
    public void print(){
        Node n = this.head;
        while (n != null){
            System.out.print (n.value + " ");
            n = n.next;
        }

        System.out.println();
    }

    @Override
    public int size() {
        int count = 0;

        Node n = this.head;
        while (n != null) {
            n = n.next;
            count++;
        }

        return count;
    }



    @Override
    public void introduceCycleForTest() {
        Node tail = this.head;
        while (tail.next != null) {
            tail = tail.next;
        }

        Random random = new Random();
        int index = random.nextInt(size()-1);

        Node n = this.head;
        for (int i = 0; i < index; ++i){
            n = n.next;
        }

        tail.next = n;

        System.out.println("cycle start: " + n.value);
        System.out.println("cycle end: " + tail.value);


    }

    @Override
    public boolean hasCycle() {
        Set<Node> cycleSet = new HashSet<>();

        Node node = this.head;
        cycleSet.add(node);
        while (node != null) {
            node = node.next;

            if (!cycleSet.add(node))
                return true;
        }

        return false;

    }

    // This solution is "Floyd's Cycle-Finding Algorithm"
    // as published in "Non-deterministic Algorithms" by Robert W. Floyd in 1967.
    // It is also called "The Tortoise and the Hare Algorithm".
    @Override
    public Node hasCycle2(){
        Node slowNode, fastNode;
        slowNode = this.head;
        fastNode = this.head;
        while (slowNode != null) {
            if (fastNode == null)
                return null;
            fastNode = fastNode.next;
            if (fastNode == null)
                return null;
            fastNode = fastNode.next;
            if (slowNode == fastNode)
                return slowNode;
            slowNode = slowNode.next;
        }
        return null;
    }

    @Override
    public int countCycle(Node cycleStart) {
        Node slowNode = cycleStart;
        Node fastNode = cycleStart;
        int cnt = 0;
        while (slowNode != null) {

            if (fastNode == null)
                return 0;
            fastNode = fastNode.next;
            if (fastNode == null)
                return 0;
            cnt++;
            System.out.println("\tcycle node: " + slowNode.value);
            fastNode = fastNode.next;
            if (slowNode == fastNode)
                return cnt;
            slowNode = slowNode.next;

        }
        return 0;
    }

}
