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
            T value = this.current.data;
            this.current = this.current.next;
            return value;
        }

        @Override
        public void remove() {
            //TODO
        }
    }



    Node head, tail;

    public ListImpl() {
        this.head = null;
        this.tail = null;
    }




    @Override
    public void appendFront(T value) {
        Node<T> node = new Node<>(value);
        if (this.head == null) {
            this.head = node;
            this.tail = node;
        }
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
    public void appendBack(T value) {
//       Node<T> newNode = new Node<>(data);
//       if (this.head == null)
//           this.head = newNode;
//       else {
//           Node curr = this.head;
//           Node prev = this.head;
//
//           // move to last node (before null)
//           while (curr != null) {
//               prev = curr;
//               curr = curr.next;
//           }
//           prev.next = newNode;
//           this.tail = newNode;
//       }

        Node<T> node = new Node<>(value);
        if (this.tail == null) {
            this.head = node;
            this.tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }
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
        this.tail = prev;
        return curr;
    }

    @Override
    public boolean delete(T value) {
        if (head == null)
            return false;

        if (this.head.data.equals(value)) { // move head up one
            this.head = this.head.next;
            return true;
        }

        Node curr = head, prev = head;
        while (curr != null) {
            if (curr.data.equals(value)) {
                prev.next = curr.next; // deletes current
                return true;

            }
            prev = curr;
            curr = curr.next;
        }

        if (curr == null)
                this.tail = prev;

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
        Node prevNode = null;
        while (curr != null) {
            curr = curr.next;

            // go to one before end
            Node endNode = this.head;
            while (endNode.next != null) {
                prevNode = endNode;
                endNode = endNode.next;
            }

            //reverse end most link
            endNode.next = prevNode;
            // shorten original list
            prevNode.next = null;
        }

        this.tail = head;
        head = tail;
    }

    // scaffold approach O(n)view
    // 1. B -> A reverse
    // 2. move everything along A-> B,  B-> C, C-> C(next)
    // iterate
    @Override
    public  void reverse() {
        Node A = null, B = head, C= head.next;

        while (B != null) {
            B.next = A; //reversal step

            // move the scaffold
            A = B;
            B = C;

            if (C!=null)
                C = C.next;
        }

        this.tail = head;
        this.head = A; // don't forget to set the head !!!
    }

    public void reverseRecurse () {
        reverseRecurse(this.head);
    }

    //TODO NEEDS MORE INVESTIGATION !!!!!!!!!!!!!!!!!!!!!
    public Node reverseRecurse (Node node){
        if (node == null) return null;
        if (node.next == null) return node;

        Node secondElem = node.next;
        node.next = null;
        Node reverseRest = reverseRecurse(secondElem);
        secondElem.next = node;
        return reverseRest;
    }

    @Override
    public void print(){
        Node curr = this.head;
        while (curr != null){
            System.out.print (curr.data + " ");
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

        System.out.println("cycle start: " + n.data);
        System.out.println("cycle end: " + tail.data);
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
            System.out.println("\tcycle node: " + slowNode.data);
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
            curr.data = value;

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
            return (T)curr.data;

        return null;
    }

    @Override
    public void toArray(T[] array) {
        Node<T> curr = this.head;
        int cnt = 0;
        while (curr != null){
            array[cnt++]=curr.data;
            curr = curr.next;
        }
    }


    // locate if elements of sublist are in larger list
    // assumptions - sublist smaller than large list
    public boolean orderedElementsFound(List<T> subList) {
        Node<T> curr = this.head; //trick persist outer list iterator and not reset on inner loop
        //iterate over inner list

        Iterator<T> iterator = subList.iterator();

        while  (iterator.hasNext()) {
            T subListElem = iterator.next();
            boolean elemFound = false;

            //move along outer list (do not rest to beginning for O(n)
            for (; curr != null; curr = curr.next) {
                if (subListElem.equals(curr.data)) {
                    elemFound = true;
                    curr = curr.next;
                    break;
                }
            }
            if (!elemFound)
                return false;
        }

        return true;
    }


    public void insertInOrder(T data){

        Node<T> node = new Node<>(data);
        if (head == null){
            head = node;
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while(curr != null){
            if (node.data.compareTo(curr.data) < 0){
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (prev == null){
            node.next = head;
            head = node;
            return;
        }

        prev.next = node;
        node.next = curr;

        System.out.println("Adding to list: " + data);

    }
}
