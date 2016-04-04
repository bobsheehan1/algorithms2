package org.sheehan.algorithm.thread;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by bob on 9/16/14.
 */

public class ThreadLocalExample {

    private final ThreadLocal<Integer> threadLocalId = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue()
        {
            Random rand = new Random();
            return rand.nextInt(1000);
        }
    };

    // Returns the current thread's unique ID, assigning it if necessary
    public int get() {
        return threadLocalId.get();
    }



    public static void main(String args[]){

        int numThreads = 5;
        ExecutorService es = Executors.newFixedThreadPool(numThreads);
        System.out.println("Start threads");

        ThreadLocalExample example = new ThreadLocalExample();
        for (int i = 0; i < numThreads; ++i)
        {
            es.submit(() -> System.out.println("thread id: " + Thread.currentThread().getId() + " thread laocal id:" + example.get()));
        }
        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Finished all threads");
    }
}
