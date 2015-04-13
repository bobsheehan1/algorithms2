package org.sheehan.algorithm;

import org.junit.Test;
import org.sheehan.algorithm.thread.ConsumerProducer2;

public class ConsumerProducer2Test {

    @Test
    public void test() throws InterruptedException {
        ConsumerProducer2 tu = new ConsumerProducer2();
        ConsumerProducer2.Mailbox mailbox = tu.new Mailbox();

        Thread produce = new Thread(tu.new Producer(mailbox), "Producer");
        Thread consume = new Thread(tu.new Consumer(mailbox), "Consumer");

        consume.start();
        produce.start();
        produce.join(10000);


    }

}