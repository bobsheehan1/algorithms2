package org.sheehan.algorithm;

import org.junit.Test;

import static org.junit.Assert.*;

public class ListImplTest {

    @Test
    public void testAppend() throws Exception {
        ListImpl<Integer> list = new ListImpl<Integer>();

        for (int i = 0; i < 10; i++)
            list.append(i);

        list.print();

        //list.reverse1();

        //list.print();

        list.reverse2();

        list.print();
    }
}