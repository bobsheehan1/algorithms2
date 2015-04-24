package org.sheehan.algorithm.thread;



import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by bob on 6/27/14.
 */
public class ConsumerProducer2 {

    final int MAX_MESSAGES = 10;

    // object that threads will synchronize on (see the get/add methods)
    public class Mailbox {

        Queue<String> messages = new LinkedList<String>();

        synchronized public String get() throws InterruptedException {
            System.out.println("get acquire lock");
            while(messages.peek() == null) {
                System.out.println("get release lock - wait");
                wait();
                System.out.println("get acquire lock - wait end");
            }
            System.out.println("remove message");
            String message = messages.remove();
            notifyAll();
            System.out.println("get release lock");
            return message;
        }

        synchronized public void add(String message) throws InterruptedException {
            System.out.println("add acquire lock");
            //thread wait until messages have been read
            while(messages.size() >= MAX_MESSAGES) {
                System.out.println("add release lock - wait");
                wait();
                System.out.println("add acquire lock - wait end");
            }

            System.out.println("ADD message");
            messages.add(message);
            notifyAll();
            System.out.println("add release lock");
        }
    }

    public class Producer implements Runnable{

        private final Mailbox mbox;
        public Producer(Mailbox mailbox){
            mbox = mailbox;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i){
                try {
                    mbox.add("message " + i);
                    System.out.println("PRODUCE: " + "message " + i);
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(500); // control rate of production
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public class Consumer implements Runnable{
        private final Mailbox mbox;
        public Consumer(Mailbox mailbox){
            mbox = mailbox;
        }
        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i) {
                try {
                    System.out.println("CONSUME: " + mbox.get());
                    System.out.println();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String []args) throws InterruptedException {

        ConsumerProducer2 tu = new ConsumerProducer2();
        ConsumerProducer2.Mailbox mailbox = tu.new Mailbox();

        Thread produce = new Thread(tu.new Producer(mailbox), "Producer");
        Thread consume = new Thread(tu.new Consumer(mailbox), "Consumer");

        consume.start();
        produce.start();
        produce.join(5000);


    }


}
