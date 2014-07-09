package org.sheehan.algorithm;

/**
 * Created by bob on 6/5/14.
 */
public class Array {

    // print start index, length, element value of longest run in array
    public static <T> void findLongestRun(T array[]) {
       int length = 1;
       int maxLength = 0;
       T maxVal = null;
       int start = -1;
       int maxStart = -1;

       for (int i = 0; i < array.length-1; ++i) {
            if (array[i].equals(array[i+1])){
                length++;
                if(start == -1)
                    start = i;
            }

            if (!array[i].equals(array[i+1]) || i == array.length-2){
                if (length > maxLength) {
                    maxLength = length;
                    maxVal = array[i];
                    maxStart = start;
                }
                length = 1;
                start = -1;
            }
        }

        System.out.println("start: " +maxStart+" length: "+maxLength+" value: "+maxVal);


    }
}
