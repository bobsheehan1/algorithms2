package org.sheehan.algorithm;

/**
 * Created by bob on 6/27/14.
 */
public class ConsumerProducer2 {

    final int MAX_MESSAGES = 10;

    class Mailbox {

        Queue<String> messages = new QueueImpl<>(MAX_MESSAGES);

        synchronized public String get() throws InterruptedException {
            while(messages.peek() == null) {
                wait();
            }
            String message = messages.remove();
            notifyAll();
            return message;
        }

        synchronized public void set(String message) throws InterruptedException {
            while(messages.peek() != null)
                wait();

            messages.add(message);
            notifyAll();
        }
    }

    class Producer implements Runnable{

        private final Mailbox mbox;
        public Producer(Mailbox mailbox){
            mbox = mailbox;
        }

        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i){
                try {
                    mbox.set("message " +  i);
                    System.out.println("message set: " + "message " +  i);
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
        public Consumer(Mailbox mailbox){
            mbox = mailbox;
        }
        @Override
        public void run() {
            for (int i = 0; i < MAX_MESSAGES; ++i) {
                try {
                    System.out.println("message get: " + mbox.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
