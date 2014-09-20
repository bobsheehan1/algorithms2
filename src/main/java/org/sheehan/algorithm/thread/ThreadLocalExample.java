package org.sheehan.algorithm.thread;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by bob on 9/16/14.
 */

public class ThreadLocalExample {

    private static final ThreadLocal<Integer> id = new ThreadLocal<Integer>()
    {
        @Override
        protected Integer initialValue()
        {
            Random rand = new Random();
            return rand.nextInt(100);
        }
    };

    class ExampleThread implements Runnable{
         @Override
        public void run() {
            System.out.println(id.get());
        }
    }

    public static void main(String args[]){
        final int numThreads = 5;
        ThreadLocalExample.ExampleThread threads[] = new ThreadLocalExample.ExampleThread[numThreads];
        for (int i = 0; i < numThreads; ++i){
            threads[i] = new ThreadLocalExample().new ExampleThread() ;
        }

        ExecutorService es = Executors.newFixedThreadPool(numThreads);
        System.out.println("Start threads");
        for (int i = 0; i < numThreads; ++i)
        {
            es.submit(threads[i]);
        }
        es.shutdown();
        while (!es.isTerminated()) {
        }

        es = Executors.newFixedThreadPool(numThreads);
        System.out.println("Start threads");
        for (int i = 0; i < numThreads; ++i)
        {
            es.submit(threads[i]);
        }
        es.shutdown();
        while (!es.isTerminated()) {
        }



        System.out.println("Finished all threads");
    }
}
