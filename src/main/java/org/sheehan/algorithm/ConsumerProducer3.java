package org.sheehan.algorithm;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by bob on 6/27/14.
 */
public class ConsumerProducer3 {

    final int MAX_MESSAGES = 10;

    class Mailbox {

        BlockingQueue<String> messages = new LinkedBlockingQueue<>();

        public String get() throws InterruptedException {
            String message = messages.take();
            return message;

        }

        public void set(String message) throws InterruptedException {
            messages.put(message);
        }
    }

    class Producer implements Runnable{

        private final Mailbox mbox;
        private final String id;

        public Producer(Mailbox mailbox, String id){

            mbox = mailbox;
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i){
                try {
                    mbox.set(id + " : " + i);
                    //System.out.println(id +" set: " +  i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
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
        private final Mailbox mbox;
        private final String id;

        public Consumer(Mailbox mailbox, String id){
            mbox = mailbox; this.id = id;
        }
        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i) {
                try {
                    System.out.println(id +" get: " +  mbox.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
