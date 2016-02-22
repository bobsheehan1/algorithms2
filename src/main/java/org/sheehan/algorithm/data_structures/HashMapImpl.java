package org.sheehan.algorithm.data_structures;

/**
 * Created by bsheehan on 2/22/16.
 */
public class HashMapImpl<K,V> {

    class Node<K,V> {
        K key;
        V value;
        Node<K,V> next;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            next = null;
        }
    }

    int size = 16;
    Node<K,V> []table = (Node<K,V>[]) new Node[size];

    public void put(K key, V value) {
        int hash = hashify(key);
        Node<K,V> node = table[hash];

        Node<K,V> curr = node;
        Node<K,V> prev = node;
        while(curr.next != null){
            if (node.key.equals(key)) {
                node.value = value; // update
                return;
            }
            prev = curr;
            curr = curr.next;
        }

        // new entry
        Node<K,V> newNode = new Node<>(key,value);
        prev.next = newNode;

    }

    public V get(K key) {
        int hash = hashify(key);
        Node<K,V> node = table[hash];

        Node<K,V> curr = node;
        while(curr.next != null){
            if (node.key.equals(key))
                return node.value;
            curr = curr.next;
        }
        return null;
    }

    private int hashify(K key) {
        return key.hashCode()%size;
    }

    public void print() {
        for (int i =0; i < size; ++i){
            Node<K,V> curr = table[i];
            while(curr.next != null){
                System.out.print(curr.key + " " + curr.value + " ");
                curr = curr.next;
            }
            System.out.println();
        }
    }


}
