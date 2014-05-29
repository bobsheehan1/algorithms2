package org.sheehan.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueImplTest {

    @Test
    public void testAddRemove() throws Exception {
        int size = 10;
        Queue q = new QueueImpl<Integer>(size);

        for (int i = 0; i < size; ++i){
            q.add(i);
            q.print();
        }

        for (int i = 0; i < size; ++i){
            q.remove();
            q.print();
        }
    }

    @Test
    public void testAddRemove2() throws Exception {
        int size = 10;
        Queue q = new QueueImpl<Integer>(size);

        // fill queue
        for (int i = 0; i < size; ++i){
            q.add(i);
            q.print();
        }

        //remove half
        for (int i = 0; i < size/2; ++i){
            q.remove();
            q.print();
        }

        // add 5 more queue
        for (int i =  size/2; i < size; ++i){
            q.add(i*10);
            q.print();
        }

        //remove half
        for (int i = 0; i < size/2; ++i){
            q.remove();
            q.print();
        }
    }
}