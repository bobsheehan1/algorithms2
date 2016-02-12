package org.sheehan.algorithm.sort;

import org.sheehan.algorithm.data_structures.*;
import org.sheehan.algorithm.data_structures.tree.BinaryHeap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: bsheehan
 * Date: 5/20/14
 * Time: 7:43 AM
 * To change this template use File | Settings | File Templates.
 */

interface SwapCallback {
    <T extends Comparable<T>> boolean swap(T[] array, int i, int j);
}

class SwapCallbackValue implements SwapCallback{
    public <T extends Comparable<T>> boolean swap(T[] array, int i, int j) {
        if (array[i].compareTo(array[j]) > 0) {
            T tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            return true;
        }
        return false;
    }
}

public class Sort {

    /////////////////////////////////////////////////////////////////////////////////
    // BUBBLE SORT
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n)
    public static void bubbleSort(Integer []array) {

        int n = array.length - 1;

        SwapCallbackValue swabCallback = new SwapCallbackValue();

        boolean swapped = true;
        // repeat until no more swaps
        while (swapped) {
            swapped = false;

            for (int i = 0; i < n; ++i) {
                swapped |= swabCallback.swap(array, i, i+1);

            }
            n = n - 1; //optimization
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // BUBBLE SORT Even and Odd
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n)
    public static void bubbleSortPolarity(int []array) {

        int n = array.length - 1;
        SwapCallbackValue swabCallback = new SwapCallbackValue();

        boolean swapped = true;
        // repeat until no more swaps
        while (swapped) {
            swapped = false;

            for (int i = 0; i < n; ++i) {
                //swapped |= swabCallback.swap(array, i, i+1);

                if ((array[i]&1)==1 && (array[i+1]&1)==0) {
                    Integer tmp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = tmp;
                    swapped = true;

                }
            }
            n = n - 1; //optimization
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // INSERTION SORT
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n) - if already sorted !
    // compares each new element against already sorted elements
    public static <T extends Comparable<T>> void insertionSort(T array[]){
        SwapCallbackValue swabCallback = new SwapCallbackValue();
        int n = array.length;

        // starting index to start from right and move left from
        for (int i = 0; i < n; ++i){
            // move left from i swapping as you go
            for (int j = i; j > 0; j--){
                swabCallback.swap(array, j-1, j);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // INSERTION SORT
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n) - if already sorted !
    // compares each new element against already sorted elements
    public static <T extends Comparable<T>> void insertionSortParity(T array[]){
        SwapCallbackValue swabCallback = new SwapCallbackValue();
        int n = array.length;

        // starting index to start from right and move left from
        for (int i = 1; i < n; ++i){
            // move left from i swapping as you go
            for (int j = i; j > 0; j--){
                if (array[j].compareTo(array[j-1]) < 0)
                    swabCallback.swap(array, j, j-1);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // INSERTION SORT LIST
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(n2)
    // avg O(n2)
    // best O(n) - if already sorted !
    // compares each new element against already sorted elements
    public static <T extends Comparable<T>> void insertionSort(List<T> list){
        int n = list.size();

        // starting index to start from right and move left from
        for (int i = 1; i < n; ++i){
            // move left from i swapping as you go
            for (int j = i; j > 0; j--){
                if (list.get(j).compareTo(list.get(j - 1)) < 0)
                    swap(list, j, j - 1);
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // HEAP SORT
    /////////////////////////////////////////////////////////////////////////////////
    // worst 0(nlogn)
    // avg O(nlogn)
    // best O(nlogn)
    public static void heapSort(Integer []array) {
        BinaryHeap<Integer> heap = new BinaryHeap<>(array.length, BinaryHeap.HeapType.MIN_HEAP);
        heap.buildHeap(array);
        Integer sortedArray[] = new Integer[array.length];
        Integer value;
        int cnt = 0;
        while ((value=heap.remove()) != null) {
            sortedArray[cnt++] = value;
        }
        System.arraycopy(sortedArray, 0, array, 0, array.length);
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SELECTION SORT - recursive
    // worst 0(n^2)
    // avg O(n^2)
    // best O(n^2)
    // in-place
    // if compares are cheaper than swaps may be better !
    // not stable
    ///////////////////////////////////////////////////////////////////////////////
    // loop finding minimum element and move to next position at front
    public static void selectionSort(Integer array[]) {
        //compare ith element to the min element in remainder and swap if necessary
        for (int i = 1; i < array.length; ++i) {
            int iMin = i;
            for (int j = i+1; j < array.length; ++j) {
                if (array[j] < array[iMin])
                    iMin = j;

            }

            if (i != iMin)
                swap(array, i, iMin);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // SELECTION SORT - recursive
    // worst 0(n^2)
    // avg O(n^2)
    // best O(n^2)
    // in-place
    // if compares are cheaper than swaps may be better !
    // not stable
    ///////////////////////////////////////////////////////////////////////////////
    // loop finding minimum element and move to next position at front
    public static void selectionSortRecursive(Integer array[], int start) {
        if (start < array.length){
            int iMin = start;
            // (n-1) + (n-2) + (n-3) + .. +1 = n(n-1)/2 --> O(n^2)
            for (int j = start+1; j < array.length; ++j) {
                if (array[j] < array[iMin])
                    iMin = j;

            }

            if (start != iMin)
                swap(array, start, iMin);

            selectionSortRecursive(array, start+1);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // MERGE SORT
    /////////////////////////////////////////////////////////////////////////////////
    public static <T extends Comparable<T>> T[] mergeSort(T array[])
    {
        if (array.length <= 1)
            return array;

        int size1 = array.length/2;
        int size2 = array.length - size1;
        T array1[] = (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size1);
        T array2[] = (T[]) java.lang.reflect.Array.newInstance(Comparable.class, size2);

        System.arraycopy(array, 0, array1, 0, size1);
        System.arraycopy(array, size1, array2, 0, size2);

        mergeSort(array1);
        mergeSort(array2);

        //overwrite array with merge
        org.sheehan.algorithm.data_structures.Array.mergeSortedArrays(array1, array2, array);
        return array;
    }


    private static <T> void swap(T[] array, int i, int j) {
        T tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }


    // simplified for ints
    public static int[] mergeSort2(int []array) {
        if (array.length <= 1) {
            return array;
        }

        // Split the array in half
        int[] first = new int[array.length / 2];
        int[] second = new int[array.length - first.length];

        System.arraycopy(array, 0, first, 0, first.length);
        System.arraycopy(array, first.length, second, 0, second.length);

        // Sort each half
        mergeSort2(first);
        mergeSort2(second);

        // Merge the halves together, overwriting the original array
        merge2(first, second, array);
        return array;
    }

    private static void merge2(int[] array1, int[]array2, int[]array){

        int i, index1, index2;
        i = 0;
        index1 = 0;
        index2 = 0;

        // merge COMMON LENGTH of 2 arrays
        // this merge actually SORTS the arrays !
        // this will exhaust one of the two arrays
        while(index1 < array1.length && index2 < array2.length){
            if (array1[index1] < array2[index2]) {
                array[i++] = array1[index1++];
            } else {
                array[i++] = array2[index2++];
            }
        }

        // one will have left overs...

        // merge the LEFT OVER array portion
        while(index1 < array1.length){
            array[i++] = array1[index1++];
        }
        // if remaining array2 not merged
        while(index2 < array2.length){
            array[i++] = array2[index2++];
        }
    }


    private static <T extends Comparable<T>> void swap(List<T> list, int i, int j) {
        T tmp = list.get(j);
        list.set(j, list.get(i));
        list.set(i, tmp);
    }


    /////////////////////////////////////////////////////////////////////////////////
    // QUICKSORT
    //
    // It can be about two or three times faster than its main competitors, merge sort and heapsort.
    //
    // Quicksort is a comparison sort, meaning that it can sort items of any type for which a "less-than" relation (formally, a total order) is defined.
    // In efficient implementations it is not a stable sort, meaning that the relative order of equal sort items is not preserved.
    // Quicksort can operate in-place on an array, requiring small additional amounts of memory to perform the sorting.
    //
    // Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n) comparisons to sort n items.
    // In the worst case, it makes O(n2) comparisons, though this behavior is rare.
    //
    // Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller sub-arrays: the low elements and the high elements. Quicksort can then recursively sort the sub-arrays.

    // The steps are:

    //      1 Pick an element, called a pivot, from the array.
    //      2 Reorder the array so that all elements with values less than the pivot come before the pivot,
    //          while all elements with values greater than the pivot come after it (equal values can go either way).
    //      3 After this partitioning, the pivot is in its final position. This is called the partition operation.
    //
    // Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater values.
    /////////////////////////////////////////////////////////////////////////////////
    public static <T extends Comparable<T>> void quicksort(T[] array, int left, int right){
        if (left < right) {
            int partitionIndex = partition(array, left, right);
            quicksort(array, left, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, right);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] array, int left, int right) {
        // left is the index of the leftmost element of the subarray
        // right is the index of the rightmost element of the subarray (inclusive)
        // number of elements in subarray = right-left+1
        int pivotIndex = choosePivot(array, left, right);
        T pivotValue = array[pivotIndex];
        //TODO may not need this swap !
        swap(array, pivotIndex, right); // Move pivot off to rightmost place for safe keeping

        // in-place swap ! could use 2 separate arrays then merge but not as efficient.
        int storeIndex = left;
        for( int i = left; i < right; i++){
            if (array[i].compareTo(pivotValue) < 0) {
                swap(array, i, storeIndex);
                // This gets add to next element but will remain here if compare fails while it keeps moving.
                // Implies that storeIndex value is larger than pivot value. Only swap with value larger than pivot.
                // If an element is lower than the pivot, you should swap it with a larger element on the left-side of i.
                storeIndex = storeIndex + 1;
            }
        }
        swap(array, storeIndex, right);// Move pivot to its final place
        return storeIndex;
    }

    private static <T> int choosePivot(T[] array, int left, int right) {
        return left; //TODO optimize
    }


    public static <T extends Comparable<T>> int quicksortSelectKSmallest(T[] array, int left, int right, int k){
        if (left <= right) {
            int partitionIndex = partition(array, left, right);
            if (partitionIndex == k)
                return partitionIndex;
            else if (k < partitionIndex)
                return quicksortSelectKSmallest(array, left, partitionIndex - 1, k);
            else
                return quicksortSelectKSmallest(array, partitionIndex + 1, right, k);
        }

        return -1;
    }

    /////////////////////////////////////////////////////////////////////////////////
    // COUNTING SORT
    /////////////////////////////////////////////////////////////////////////////////
    private static final int MAX_RANGE = 1000000;
    public static void countingSort(Integer array[]) {

        if (array.length == 0)
            return;

        /** find max and min values **/
        int max = array[0], min = array[0];

        for (int i = 0; i < array.length; i++)
        {
            if (array[i] > max)
                max = array[i];

            if (array[i] < min)
                min = array[i];
        }

        final int range = max - min + 1;

        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;

        }
        Integer counts[] = (Integer[]) Array.newInstance(Integer.class, range);
        Integer output[] = (Integer[]) Array.newInstance(Integer.class, array.length);

        Arrays.fill(counts, 0);

        // histogram
        // how many of each element is there ?
        for (int i = 0; i < array.length; ++i) {
            counts[array[i]-min] += 1;
        }

        // accumulate - "prefix sum" counts[i] contains # of values <=
        // counts[i]
        // it instead stores the number of items with key less than i,
        // which is the same as the first index at which an item with key i should be stored in the output array.
        for (int i = 1; i < range; ++i) {
            counts[i] += counts[i - 1];
        }

        // create sorted output
        for (int i = 0 ; i < array.length; i++) {
            counts[array[i] - min] -= 1; // decrement count
            //System.out.println("# items <= " + array[i] + " is " + counts[array[i] - min]);
            //System.out.println("setting output index " + counts[array[i] - min] + " to " + array[i]);
            output[counts[array[i] - min]] = array[i];

        }

        // copy output back to array
        System.arraycopy( output, 0, array, 0, array.length );
    }

    /////////////////////////////////////////////////////////////////////////////////
    // RADIX SORT
    // LSD on integer keys
    // BASE = 10
    /////////////////////////////////////////////////////////////////////////////////
    public static void radixSort(Integer array[]) {
        final int BASE = 10;
        int numBuckets = BASE;

        List<Queue<Integer>> buckets = new ListImpl<Queue<Integer>>();
        for (int i = 0; i < numBuckets; i++){
            buckets.appendBack(new QueueImpl<Integer>(array.length));
        }

        Integer max = Integer.MIN_VALUE;
        for (Integer value: array)
            max = Math.max(value,max);


        // while there is a max element larger positional value, iterate another bucket sorting pass
        // moving the position from right to left by one
        for (int positionMultiplier=1; max >= positionMultiplier; positionMultiplier *= BASE) {
            // each pass checks a rt to left position and buckets based on that digit
            for (Integer value : array){
                int valueDiv = value/positionMultiplier;
                int valueMod = valueDiv%BASE;
                buckets.get(valueMod).add(value);
            }

            // reset array to new order after sorting this pass
            // the new order is obtained by removing elements from the bucket queues in FIFO order
            // starting from least valued bucket

            for (int bucketIndex = 0, i = 0; bucketIndex < numBuckets; ++bucketIndex){
                Queue<Integer> bucket = buckets.get(bucketIndex);
                Integer value;
                while ((value = bucket.remove()) != null){
                    array[i++] = value;
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // RADIX SORT
    // LSD on integer keys (left to right)
    // BASE = 2
    /////////////////////////////////////////////////////////////////////////////////
    public static void radixSortBinaryLsd(Integer array[]) {
        final int BASE = 2;
        final int numBuckets = 2;

        List<Queue<Integer>> buckets = new ListImpl<Queue<Integer>>();
        for (int i = 0; i < numBuckets; i++){
            buckets.appendBack(new QueueImpl<Integer>(array.length));
        }

        int MASK = 0x00000001;

        // while there is a max element larger positional value, iterate another bucket sorting pass
        // moving the position from right to left by one
        for (int position=0; position < Integer.SIZE; position++) {
            // each pass checks a rt to left position and buckets based on that digit
            for (Integer value : array){
                int bitValue = value & MASK;
                bitValue >>>= position;
                buckets.get(bitValue).add(value);
            }
            MASK <<= 1;


            // reset array to new order after sorting this pass
            // the new order is obtained by removing elements from the bucket queues in FIFO order
            // starting from least valued bucket
            int i = 0;
            for (int bucketIndex = 0; bucketIndex < numBuckets; ++bucketIndex){
                Queue<Integer> bucket = buckets.get(bucketIndex);
                Integer value;
                while ((value = bucket.remove()) != null){
                    array[i++] = value;
                }
            }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    // RADIX SORT
    // LSD on fixed length lexical keys
    // bucket for each ascii char
    // sort iteratively by single character moving left
    /////////////////////////////////////////////////////////////////////////////////
    public static void radixSortLexicalFixedLsd(String array[]) {
        // 256 ASCII character positions
        final int numBuckets = 256;
        List<Queue<String>> buckets = new ListImpl<Queue<String>>();
        for (int i = 0; i < numBuckets; i++){
            buckets.appendBack(new QueueImpl<String>(array.length));
        }

        Integer max = Integer.MIN_VALUE;
        for (String value: array)
            max = (max < value.length()) ? value.length():max;

        // while there is a max element larger positional value, iterate another bucket sorting pass
        // moving the position from left to right by one
        for (int position=max-1; position>=0; position--) {
            // each pass checks a rt to left position and buckets based on that digit
            for (String value : array){
                char c = value.charAt(position);
                buckets.get(Character.getNumericValue(c)).add(value);
            }

            // reset array to new order after sorting this pass
            // the new order is obtained by removing elements from the bucket queues in FIFO order
            // starting from least valued bucket
            int i = 0;
            for (int bucketIndex = 0; bucketIndex < numBuckets; ++bucketIndex){
                Queue<String> bucket = buckets.get(bucketIndex);
                String value;
                while ((value = bucket.remove()) != null){
                    array[i++] = value;
                }
            }
        }
    }

    // 1. bucket the strings by length (maxlen buckets)
    // 2. reset the input array to be sorted by length using the buckets
    // 3. left to right radix sort into 256 (ASCII) alpha buckets.
    // 3a. start on left most position on longest strings,
    // 3b. then as the position is moved to the right include additional bucket of that smaller
    //     length.
    // 3c. Each pass reset input array to new order determined by alpha buckets
    // 3d. By the time you are down the last rightmost char input array will be reset to sorted ordered

    public static void radixSortVarLengthMsd( String [ ] arr, int maxLen ) {
        final int BUCKETS = 256;

        java.util.List<java.util.List<String>> lengthBuckets = new ArrayList<java.util.List<String>>();
        java.util.List<java.util.List<String>> alphaBuckets = new ArrayList<java.util.List<String>>();

        for (int i = 0; i < arr.length; i++)
            lengthBuckets.add(new ArrayList<String>());

        for (int i = 0; i < BUCKETS; i++)
            alphaBuckets.add(new ArrayList<String>());

        // create buckets for each length and sort the strings by length into each bucket.
        for (String s : arr)
            lengthBuckets.get(s.length()).add(s);

        // reinit array so all strings are sorted by length, not alpha yet !
        int idx = 0;
        for (java.util.List<String> lengthBucket : lengthBuckets)
            for (String fixedLengthStr : lengthBucket)
                arr[idx++] = fixedLengthStr;

        // now starting with longest strings, go bucket by bucket to shortest strings
        // subsequent passes as we move the position to the right will include the already
        // sorted longer strings
        int startingStrIndex = arr.length;
        for (int charPos = maxLen - 1; charPos >= 0; charPos--) {
            // index into arr for strings of the same length
            startingStrIndex -= lengthBuckets.get(charPos + 1).size();

            // index into arr for strings of the same length
            // NOW WE ADD TO ALPHA BUCKET based on pos value from arr
            // Do this for each string of this length
            for (int i = startingStrIndex; i < arr.length; i++) {
                alphaBuckets.get(arr[i].charAt(charPos)).add(arr[i]);
            }

            // NOW we iterate over ALPHA buckets one at a time and
            // add in order to arr starting from startingIndex.
            // This sorts all the strings of that length
            idx = startingStrIndex;
            for (java.util.List<String> thisAlphaBucket : alphaBuckets) {
                for (String s : thisAlphaBucket) {
                    arr[idx++] = s; // adds in sorted order !
                }

                thisAlphaBucket.clear();
            }
        }
    }
}
