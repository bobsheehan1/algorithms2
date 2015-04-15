package org.sheehan.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bob on 8/2/14.
 *
 * Given items each of value and weight, and a container with capacity W
 * Find optimal set of items to maximize total value for W
 */
public class Scraper {



    public static class Building {
        private Integer value;
        private Integer weight;

        public Building(Integer value, Integer weight){
            this.value= value;
            this.weight = weight;
        }

        public Integer getValue(){
            return this.value;
        }

        public Integer getWeight(){
            return this.weight;
        }
    }

    private Building items[];
    private Integer weightCapacity;

    // i is number of items
    // j is residual knapsack capacity
    private Integer knapsackSolutions[][];

    public Scraper(Building[] items, Integer weightCapacity) {


        this.items = items;
        this.weightCapacity = weightCapacity;
        this.knapsackSolutions = new Integer[weightCapacity+1][items.length+1];

        System.out.println("Items:");
        for (int i = 0; i < items.length; ++i){
            System.out.println((i + 1) + " " + items[i].getValue() + "," + items[i].getWeight());
        }

    }

    public void printSolutions() {
        for (int residualCapacity = 0; residualCapacity <= weightCapacity; ++residualCapacity) {
            String value = String.format("%6d: ", residualCapacity);
            System.out.print(value);
            for (int itemConsidered = 0; itemConsidered <= items.length; ++itemConsidered) {
                // rows are for a given residual capacity
                value = String.format("%6d", this.knapsackSolutions[residualCapacity][itemConsidered]);
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
            this.knapsackSolutions[capacityIndex][0] = 0;

        // table rows are item numbers
        for (int itemIndex=1; itemIndex<= items.length; ++itemIndex){
            // cols are for a given residual capacity
            for (int capacityIndex=0; capacityIndex<= weightCapacity; ++capacityIndex) {

                int currentWeight = this.items[itemIndex-1].getWeight();

                int previousMaxValueSolution = this.knapsackSolutions[capacityIndex][itemIndex-1];


                // if this item weight is bigger than residual capacity then use previous
                if (currentWeight > capacityIndex)
                {
                    this.knapsackSolutions[capacityIndex][itemIndex] = this.knapsackSolutions[capacityIndex][itemIndex-1];
                    continue;
                }

                int currentValue = this.items[itemIndex-1].getValue();

                // last solution that with weight offset by current weight ...added to current value
                int currentSolution = this.knapsackSolutions[capacityIndex-currentWeight][itemIndex-1] + currentValue;
                this.knapsackSolutions[capacityIndex][itemIndex] = Math.max(previousMaxValueSolution, currentSolution);
            }
        }

        return this.knapsackSolutions[weightCapacity][items.length];

    }

    public Set<Building> getSolutionItems()
    {
        Set<Building> items = new HashSet<>();

        int capacityIndex = this.weightCapacity;

        Building addItem = null;
        for (int itemIndex = this.items.length; itemIndex > 0; itemIndex--) {
            if (knapsackSolutions[capacityIndex][itemIndex] == knapsackSolutions[capacityIndex][itemIndex-1]) {
                continue;
            }else {
                items.add(this.items[itemIndex-1]);
                capacityIndex = capacityIndex - this.items[itemIndex-1].weight;
            }
        }

        return items;
    }
}