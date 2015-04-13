package org.sheehan.algorithm.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by bob on 9/15/14.
 */
public class DiningPhilosophers {
    static int chopStickCnt = 0;
    static int philosopherCnt = 0;

    class Chopstick {
        private final int id;

        public Chopstick()
        {
            this.id = chopStickCnt++;
        }
    }

    class Philosopher implements Runnable{
        private final Chopstick left;
        private final Chopstick right;
        private final int id;
        private int amount = 0;

        public Philosopher(Chopstick left, Chopstick right){
            this.left = left;
            this.right = right;
            this.id = philosopherCnt++;
        }

        @Override
        public String toString(){
            return "Philosopher: " + id + " " + this.left.id + " " + this.right.id + " amount " + amount;
        }

        @Override
        public void run() {
            System.out.println(this + " hungry");
            while (true) {//keep eating forever

                /// creates a race condition and deadlock if all philos pick up left fork first.
                synchronized (this.left) {
                    System.out.println(this + "\tacquire left "+ left.id);
                    synchronized (this.right) {
                        System.out.println(this + "\t\tacquire right "+ right.id);
                        System.out.println(this + "\t\t\teating !");
                        amount++;

                    }
                    System.out.println(this + "\t\trelease right "+ right.id);
                }
                System.out.println(this + "\trelease left "+ left.id);
            }
        }
    }

    private List<Philosopher> philosophers;
    private List<Chopstick> chopsticks;
    public void initialize(int numDining){

        philosophers = new ArrayList<>();
        chopsticks = new ArrayList<>();
        for (int i = 0; i < numDining; ++i){
            chopsticks.add(new Chopstick());
        }
        for (int i = 0; i < numDining; ++i){
            // HERE IS THE DEADLOCK SITUATION
            // race condition: if a philosopher holds a left fork, then who will get the right/left fork ?????
            // deadlock condition: when 4 philosophers have a left fork and 1 fork remaining..... no one can get it !!
            // FIX - reordering resource acquisition - have one philospher pick up right fork first.
             if (i == 0)
                philosophers.add(new Philosopher(chopsticks.get(i), chopsticks.get((i+1)%numDining)));
             else
                 philosophers.add(new Philosopher(chopsticks.get((i+1)%numDining),chopsticks.get(i)));
        }
    }

    public static void runSimulation() throws InterruptedException {
        DiningPhilosophers dp = new DiningPhilosophers();
        dp.initialize(5);
        dp.print();
        dp.eat();
    }

    private void eat() throws InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(philosophers.size());
        for (Philosopher p: philosophers)
            es.submit(p);
        //es.awaitTermination(10, TimeUnit.SECONDS);
        es.shutdown();
        while (!es.isTerminated()) {
            //System.out.println("terminated");
        }
    }

    private void print() {
        for (Philosopher p : philosophers) {
            System.out.println(p);
        }
    }
}
