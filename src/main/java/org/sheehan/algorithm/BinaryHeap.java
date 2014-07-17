package org.sheehan.algorithm;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Created by bob on 7/13/14.
 *
 * A Heap is a specific data structure or implementation of an efficient priority queue, which is simply a type that allows
 * retrieval of elements by priority (min or max).
 *
 * This allows for specification of min or max. As a complete tree we use a fixed size array for heap implementation.
 *
 * implements a poll method which provides priority queue functionality
 */
public class BinaryHeap <T extends Comparable<T>> extends BinaryCompleteTree <T> {

    public enum HeapType {MIN_HEAP, MAX_HEAP};

    final private HeapType heapType;

    public BinaryHeap(int size, HeapType heapType){
        super(size);
        this.heapType = heapType;
    }

    // start with last node and (heapify) swap up recursively. Then iterate reverse back upt he tree.
    public void buildHeap(T array[])
    {
        this.array = array;
        count = array.length;
        for( int i = this.count-1 ; i >= 0; i-- )
            heapify(i);
    }

    //recursive from node index i up to root.
    //bubble up
    protected void heapify(int i)
    {
        int parent = parent(i);

        boolean swap = false;

        if( parent >= 0) {
            if (this.heapType==HeapType.MAX_HEAP && this.array[parent].compareTo(this.array[i]) < 0)
                swap = true;
            else if (this.heapType==HeapType.MIN_HEAP && this.array[parent].compareTo(this.array[i]) > 0)
                swap = true;
        }

        if( swap)
        {
            swap(parent, i);
            heapify(parent); //recurse upward toward root
        }
    }

    //iterative from node index i up to root.
    //bubble up
    protected void heapify2(int i)
    {
        int parentIndex = parent(i);

        boolean swap = true;

        while(parentIndex >= 0 && swap) {
            swap = false;
            if (this.heapType==HeapType.MAX_HEAP && this.array[parentIndex].compareTo(this.array[i]) < 0)
                swap = true;
            else if (this.heapType==HeapType.MIN_HEAP && this.array[parentIndex].compareTo(this.array[i]) > 0)
                swap = true;

            if (swap) {
                swap(parentIndex, i);
                i = parentIndex;
                parentIndex = parent(parentIndex);
             }
        }
    }

    // for after deleting and swapping top node - establish heap property
    protected void bubbleDown(int i)
    {
        int leftChildIndex = leftChild(i);
        int rightChildIndex = rightChild(i);

        int swap = i;
        if (leftChildIndex < count) {
            if (this.heapType==HeapType.MAX_HEAP && this.array[leftChildIndex].compareTo(this.array[i]) > 0)
                swap = leftChildIndex;
            else if (this.heapType==HeapType.MIN_HEAP && this.array[leftChildIndex].compareTo(this.array[i]) < 0)
                swap = leftChildIndex;

            if (this.heapType==HeapType.MAX_HEAP && rightChildIndex < count &&
                    this.array[rightChildIndex].compareTo(this.array[i]) > 0 &&
                    this.array[rightChildIndex].compareTo(this.array[leftChildIndex]) > 0)
                swap = rightChildIndex;
            else if (this.heapType==HeapType.MIN_HEAP && rightChildIndex < count &&
                    this.array[rightChildIndex].compareTo(this.array[i]) < 0 &&
                    this.array[rightChildIndex].compareTo(this.array[leftChildIndex]) < 0)
                swap = rightChildIndex;

            if (swap != i) {
                swap(swap,i);
                bubbleDown(swap);
            }

        }


    }

    private void swap(int index1, int index2) {
        T tmp = this.array[index1];
        this.array[index1] = this.array[ index2 ];
        this.array[ index2 ] = tmp;
    }

    @Override
    public void add(T value) {
        super.add(value);
        heapify(this.count-1);
    }

    public T poll() {
        if (count == 0)
            return null;
        T value = this.array[0];
        swap(0, count-1);
        --count;
        bubbleDown(0);
        return value;
    }
}
