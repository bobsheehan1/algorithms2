package org.sheehan.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bob on 8/2/14.
 *
 * Given items each of value and weight, and a container with capacity W
 * Find optimal enqueue of items to maximize total value for W
 */
public class Knapsack {

    public static class Item {
        private Integer value;
        private Integer weight;

        public Item(Integer value, Integer weight){
            this.value= value;
            this.weight = weight;
        }

        public Integer getValue(){
            return this.value;
        }

        public Integer getWeight(){
            return this.weight;
        }

        public String toString() {
            return "value:" + getValue() + ", weight:" + getWeight();
        }
    }

    private Item items[];
    private Integer weightCapacity;

    // i is number of items
    // j is residual knapsack capacity
    private Integer soln[][];

    public Knapsack(Item [] items, Integer weightCapacity) {

        this.items = items;
        this.weightCapacity = weightCapacity;
        this.soln = new Integer[weightCapacity+1][items.length+1];

        for (int i = 0; i < items.length; ++i){
            System.out.println("Item " + (i + 1) + " - " + items[i].toString());
        }
        System.out.println();
    }

    public void printSolutions() {
        for (int residualCapacity = 0; residualCapacity <= weightCapacity; ++residualCapacity) {
            String value = String.format("%6d: ", residualCapacity);
            System.out.print(value);
            for (int itemConsidered = 0; itemConsidered <= items.length; ++itemConsidered) {
                // rows are for a given residual capacity
                value = String.format("%6d", this.soln[residualCapacity][itemConsidered]);
                System.out.print(value);
            }

            System.out.println();
        }
        String value = String.format("%9s", "");
        System.out.print(value);
        for (int itemConsidered = 0; itemConsidered <= items.length; ++itemConsidered) {
             value = String.format("%5d ", itemConsidered);
            System.out.print(value);

        }
        System.out.println();
    }

    // todo - consider not caching sub solutions in array and reduce memory footprint
    public Integer solve() {

        // init for no items
        for (int capacityIndex=0; capacityIndex <= weightCapacity; ++capacityIndex)
            this.soln[capacityIndex][0] = 0;

        // table rows are item numbers
        for (int itemIndex=1; itemIndex<= items.length; ++itemIndex){
            // cols are for a given residual capacity
            for (int capacityIndex=0; capacityIndex<= weightCapacity; ++capacityIndex) {

                int currentWeight = this.items[itemIndex-1].getWeight();

                int previousMaxValueSolution = this.soln[capacityIndex][itemIndex-1];


                // if this item weight is bigger than residual capacity then use previous
                if (currentWeight > capacityIndex)
                {
                    this.soln[capacityIndex][itemIndex] = this.soln[capacityIndex][itemIndex-1];
                    continue;
                }

                int currentValue = this.items[itemIndex-1].getValue();

                // last solution that with weight offset by current weight ...added to current value
                int currentSolution = this.soln[capacityIndex-currentWeight][itemIndex-1] + currentValue;
                this.soln[capacityIndex][itemIndex] = Math.max(previousMaxValueSolution, currentSolution);
            }
        }

        return this.soln[weightCapacity][items.length];
    }

    public Set<Item> getSolutionItems()
    {
        Set<Item> items = new HashSet<>();

        int capacityIndex = this.weightCapacity;

        Item addItem = null;
        for (int itemIndex = this.items.length; itemIndex > 0; itemIndex--) {
            if (soln[capacityIndex][itemIndex] == soln[capacityIndex][itemIndex-1]) {
                continue;
            }else {
                items.add(this.items[itemIndex-1]);
                capacityIndex = capacityIndex - this.items[itemIndex-1].weight;
            }
        }
        return items;
    }
}
