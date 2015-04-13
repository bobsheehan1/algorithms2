package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.data_structures.ListImpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class KnapsackTest {

    @Test
    public void testKnapsack(){


        List<Knapsack.Item> items1 = new ArrayList<Knapsack.Item>();
        Knapsack.Item item = new Knapsack.Item(3,4);
        items1.add(item);
        item = new Knapsack.Item(2,3);
        items1.add(item);
        item = new Knapsack.Item(4,2);
        items1.add(item);
        item = new Knapsack.Item(4,3);
        items1.add(item);

        Knapsack.Item[] items = (Knapsack.Item[])items1.toArray(new Knapsack.Item[0]);

        Knapsack knapsack = new Knapsack(items, 8);
        System.out.println("Solution: " + knapsack.solve());
        knapsack.printSolutions();

        Set<Knapsack.Item> addedItems = knapsack.getSolutionItems();
        Iterator<Knapsack.Item> iterator = addedItems.iterator();
        System.out.println("Solution items: ");
        while(iterator.hasNext() ){
            Knapsack.Item next = iterator.next();
            System.out.print(next.getValue() + "," + next.getWeight() + " ");
        }
        System.out.println();


    }

}