package org.sheehan.algorithm;

import junit.framework.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class QueueImplTest {

    @Test
    public void testAddOverflow() {
        try {
            int size = 10;
            Queue q = new QueueImpl<Integer>(size);

            for (int i = 0; i < 10; ++i) {
                q.add(i);
                q.print();
                q.printArray();
            }

            for (int i = 0; i < 5; ++i) {
                q.remove();
                q.print();
                q.printArray();
            }

            for (int i = 10; i < 15; ++i) {
                q.add(i);
                q.print();
                q.printArray();
            }
        }catch (NoSuchElementException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddRemove() throws Exception {
        int size = 10;
        Queue<Integer> q = new QueueImpl<>(size);

        for (int i = 0; i < size; ++i){
            q.add(i);
            q.print();
        }

        for (int i = 0; i < size; ++i){
            Integer remove = q.remove();
            assertEquals(i, remove.intValue());
            q.print();
        }

        q.add(10);
        q.add(20);
        assertEquals(10, q.remove().intValue());
        q.add(30);
        q.add(40);
        assertEquals(20, q.remove().intValue());

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

    @Test
    public void testAddRemove3() {
        int size = 10;
        Queue q = new QueueImpl<Integer>(size);
        q.add(5);
        Integer val = (Integer)q.remove();
        assertEquals(new Integer(5), val);

    }
}

