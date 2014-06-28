package org.sheehan.algorithm;

/**
 * Created by bob on 6/27/14.
 */
public class ConsumerProducer1 {

    int counter = 0;

    class Producer implements Runnable{

        @Override
        public void run() {
            while(true) {
                synchronized (ConsumerProducer1.this) {
                    counter++;
                    ConsumerProducer1.this.notify();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable{

        @Override
        public void run() {
            while(true) {
                synchronized (ConsumerProducer1.this) {
                    try {
                        ConsumerProducer1.this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("count:" + counter);
                }
            }
        }
    }


}
