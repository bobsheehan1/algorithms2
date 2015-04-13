package org.sheehan.algorithm;

import org.sheehan.algorithm.data_structures.Stack;
import org.sheehan.algorithm.data_structures.StackImpl;

import java.util.Arrays;

/**
 * Created by bsheehan on 9/10/2014.
 */
public class RangeMerge {



    static public class Range implements Comparable<RangeMerge.Range> {

        private int start;
        private int end;

        public Range(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Range range) {
            return start - range.start;
        }

        public boolean overlaps(Range range) {
            if (range.start >= start && range.start <= end)
                return true;
            if (range.end <= end && range.end >= start)
                return true;

            return false;
        }

        public void merge(Range range) {
            if (range.start < start)
                start = range.start;
            if (range.end > end)
                end = range.end;
        }

        @Override
        public String toString(){
           return "range: " + start + "-" + end;
        }
    }

    public Stack<Range> sort(Range ranges[]){

        // first sort ranges by starting point
        for (Range range: ranges){
            Arrays.sort(ranges) ;
        }

        Stack<Range> stack = new StackImpl<>(ranges.length);
        for (Range range : ranges){
            if (stack.peek() == null)
                stack.push(range);
            else {
                Range top = stack.peek(); // retreive the latest addition merged or disconnected
                if (top.overlaps(range)){
                    top.merge(range);
                    stack.pop();
                    stack.push(top);
                }else {
                    stack.push(range);
                }
            }
        }

        return stack;
    }
}
