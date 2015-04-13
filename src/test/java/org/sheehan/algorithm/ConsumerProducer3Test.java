package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.thread.ConsumerProducer3;

public class ConsumerProducer3Test {

    @Test
    public void test() throws InterruptedException {
        ConsumerProducer3 tu = new ConsumerProducer3();
        ConsumerProducer3.Mailbox mailbox = tu.new Mailbox();

        Thread p1 = new Thread(tu.new Producer(mailbox, "P1"), "Producer");
        Thread c1 = new Thread(tu.new Consumer(mailbox, "C1"), "Consumer");
        Thread p2 = new Thread(tu.new Producer(mailbox, "P2"), "Producer");
        Thread c2 = new Thread(tu.new Consumer(mailbox, "C2"), "Consumer");

        c1.start();
        p1.start();
        c2.start();
        p2.start();
        p1.join(10000);
        p2.join(10000);


    }

}