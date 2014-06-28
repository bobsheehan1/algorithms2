package org.sheehan.algorithm;

import org.junit.Test;

public class ConsumerProducer1Test {

    @Test
    public void test() throws InterruptedException {
        ConsumerProducer1 tu = new ConsumerProducer1();
        Thread produce = new Thread(tu.new Producer(), "Producer");
        Thread consume = new Thread(tu.new Consumer(), "Consumer");

        consume.start();
        produce.start();
        produce.join(10000);


    }

}