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
            current = nodes.head;

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

    public Node<T> head, tail;

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
        } else {
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
        } else {
            tail.next = node;
            tail = node;
        }
    }

    @Override
    public Node<T> deleteBack() {

        Node<T> curr = head;
        Node<T> prev = head;

        if (curr.next == null) {
            head = null;
            return curr;
        }
        while (curr.next != null) {
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

    //B-BABC-A
    // scaffold approach O(n)view
    // 1. B -> A reverse
    // 2. move everything along A-> B,  B-> C, C-> C(next)
    // iterate
    @Override
    public void reverse() {
        Node A = null, B = head, C = head.next;

        while (B != null) {
            B.next = A; //reversal step

            // move the scaffold
            A = B;
            B = C;

            if (C != null)
                C = C.next;
        }

        this.tail = head;
        this.head = A; // don't forget to set the head !!!
    }

    public void reverseRecurse() {
        reverseRecurse(this.head);
    }

    //TODO NEEDS MORE INVESTIGATION !!!!!!!!!!!!!!!!!!!!!
    public Node reverseRecurse(Node node) {
        if (node == null) return null;
        if (node.next == null) return node;

        Node secondElem = node.next;
        node.next = null;
        Node reverseRest = reverseRecurse(secondElem);
        secondElem.next = node;
        return reverseRest;
    }

    @Override
    public void print() {
        Node curr = this.head;
        while (curr != null) {
            System.out.print(curr.data + " ");
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
        int index = random.nextInt(size() - 1);

        Node n = this.head;
        for (int i = 0; i < index; ++i) {
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
    public Node hasCycle2() {
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
            return (T) curr.data;

        return null;
    }

    @Override
    public void toArray(T[] array) {
        Node<T> curr = this.head;
        int cnt = 0;
        while (curr != null) {
            array[cnt++] = curr.data;
            curr = curr.next;
        }
    }

    // locate if elements of sublist are in larger list
    // assumptions - sublist smaller than large list
    public boolean orderedElementsFound(List<T> subList) {
        Node<T> curr = this.head; //trick persist outer list iterator and not reset on inner loop
        //iterate over inner list

        Iterator<T> iterator = subList.iterator();

        while (iterator.hasNext()) {
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

    public void insertInOrder(T data) {

        Node<T> node = new Node<>(data);
        if (head == null) {
            head = node;
            return;
        }

        Node<T> curr = head;
        Node<T> prev = null;

        while (curr != null) {
            if (node.data.compareTo(curr.data) < 0) {
                break;
            }
            prev = curr;
            curr = curr.next;
        }

        if (prev == null) {
            node.next = head;
            head = node;
            return;
        }

        prev.next = node;
        node.next = curr;

        System.out.println("Adding to list: " + data);

    }

    /////////////////////////////////////////////////////////////////////////////////
    // INSERTION SORT LIST
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n) - if already sorted !
    // compares each new element against already sorted elements
    // This rejiggers the original list links to point in sorted order
    public static <T extends Comparable<T>> void insertionSort(ListImpl<T> list) {
        List.Node<T> head2 = null;
        List.Node<T> curr = list.head;

        while (curr != null) {
            List.Node<T> curr2 = head2;
            List.Node<T> prev2 = null;
            while (curr2 != null) {
                if (curr.data.compareTo(curr2.data) < 0) {
                    break;
                }
                prev2 = curr2;
                curr2 = curr2.next;
            }

            List.Node<T> next = curr.next; // SAVE THIS for iteration cause relinking nodes along the way !!

            // build up sorted list from beginning
            if (prev2 == null) { //insert at head
                curr.next = curr2;
                head2 = curr; // SET head of sorted list here !
            } else if (curr2 == null) {//insert at end
                prev2.next = curr;
                curr.next = null;
            } else { // insert in middle
                prev2.next = curr;
                curr.next = curr2;
            }
            curr = next; // iterate down unsorted remaining list
        }
        list.head = head2; // now set original list head to first sorted node !
    }

    // iterate over sorted array to insert minimum unsorted node
    public static <T extends Comparable<T>> void selectionSort(ListImpl<T> list) {
        List.Node<T> sortedPrev = null;
        List.Node<T> sortedCurr = list.head;

        while (sortedCurr != null) {

            boolean minFound = false;
            List.Node<T> min = sortedCurr;
            List.Node<T> minPrev = null;
            List.Node<T> unsortedCurr = sortedCurr.next;
            List.Node<T> unsortedPrev = sortedCurr;
            while (unsortedCurr != null) {
                if (unsortedCurr.data.compareTo(min.data) < 0) {
                    minPrev = unsortedPrev;
                    min = unsortedCurr;
                    minFound = true;
                }

                unsortedPrev = unsortedCurr;
                unsortedCurr = unsortedCurr.next;
            }

            if (minFound)
                swapNodes(list, sortedPrev, sortedCurr, minPrev, min);
            else
                break;

            sortedPrev = min; // min is now at the previous position
            sortedCurr = min.next; //.. so that makes curr min.next !!!
        }
    }

    private static <T extends Comparable<T>> void swapNodes(ListImpl<T> list, Node<T> prev1, Node<T> node1, Node<T> prev2, Node<T> node2) {
        if (node1 == null || node1.next == null)
            return;

        if (node1.next != node2 && node2.next != node1) { // separated non adjacent nodes
            Node<T> tmp = node1.next;
            node1.next = node2.next;
            node2.next = tmp;

            if (prev1 != null)
                prev1.next = node2;
            else
                list.head = node2; //at front
            if (prev2 != null)
                prev2.next = node1;
            else
                list.head = node1; //at front
        } else if (node1.next == node2) { // adjacent nodes
            node1.next = node2.next;
            node2.next = node1;

            if (prev1 != null)
                prev1.next = node2;
            else
                list.head = node2; //at front
        } else if (node2.next == node1) { // adjacent nodes
            node2.next = node1.next;
            node1.next = node2;

            if (prev2 != null)
                prev2.next = node1;
            else
                list.head = node1; //at front
        }
    }

    public static <T extends Comparable<T>> void swapPairs(ListImpl<T> list) {

        List.Node<T> prev = null;
        List.Node<T> curr = list.head;

        while (curr != null) {
            swapNodes(list, prev, curr, curr, curr.next);

            prev = curr;
            curr = curr.next; // this should work because curr was swapped forward !

        }
    }
}