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

        @Override
        public void remove() {
            //TODO
        }
    }



    Node head;

    public ListImpl() {
        this.head = null;
    }


   @Override
   public void appendBack(T value) {
       Node<T> newNode = new Node<>(value);
       if (this.head == null)
           this.head = newNode;
       else {
           Node curr = this.head;
           Node prev = this.head;

           // move to last node (before null)
           while (curr != null) {
               prev = curr;
               curr = curr.next;
           }
           prev.next = newNode;

       }
   }

    @Override
    public void appendFront(T value) {
        Node<T> node = new Node<>(value);
        if (this.head == null)
            this.head = node;
        else {
            node.next = head;
            head = node;
        }
    }

    @Override
    public Node<T> deleteFront() {
        Node<T> front = head;
        this.head = this.head.next;
        return front;
    }

    @Override
    public Node<T> deleteBack() {

        Node<T> curr=head;
        Node<T> prev=head;

        if (curr.next==null){
            head = null;
            return curr;
        }
        while (curr.next != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = null;
        return curr;
    }

    @Override
    public boolean delete(T value) {
        if (this.head.value.equals(value)) { // move head up one
            this.head = this.head.next;
            return true;
        }

        Node curr = head, prev = head;
        while (curr != null) {
            if (curr.value.equals(value)) {
                prev.next = curr.next; // deletes current
                return true;

            }
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    //brute force
    @Override
    public void reverseBrute() {
        Node curr = this.head;
        // move to end to get tail
        while (curr != null) {
            curr = curr.next;
        }

        // need the tail for late bro
        Node tail = curr;

        curr = this.head;
        Node prev = null;
        while (curr != null) {
            curr = curr.next;
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

    // scaffold approach O(n)view
    // 1. B -> A reverse
    // 2. move everything along A-> B,  B-> C, C-> C(next)
    // iterate
    @Override
    public  void reverse() {
        Node A = null, B = head, C= head.next;
        while (C != null) {
            B.next = A; //reversal step

            // move the scaffold
            A = B;
            B = C;
            C = C.next;
        }

        B.next = A; //reversal
        this.head = B; // don't forget to add the head !!!
    }

    @Override
    public void print(){
        Node curr = this.head;
        while (curr != null){
            System.out.print (curr.value + " ");
            curr = curr.next;
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

        // get to tail so tail can point to some random node
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

        // make loop !
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
            fastNode = fastNode.next; // double it up

            if (slowNode == fastNode) //test !
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

    @Override
    public T set(int index, T value) {
        if (index > size())
            return null;
        Node curr = this.head;
        for (int i = 0; i < index; ++i)
            curr = curr.next;

        if (curr != null)
            curr.value = value;

        return value;
    }

    @Override
    public T get(int index) {
        if (index > size())
            return null;
        Node curr = this.head;
        for (int i = 0; i < index; ++i)
            curr = curr.next;

        if (curr != null)
            return (T)curr.value;

        return null;
    }

    @Override
    public void toArray(T[] array) {
        Node<T> curr = this.head;
        int cnt = 0;
        while (curr != null){
            array[cnt++]=curr.value;
            curr = curr.next;
        }
    }

}
