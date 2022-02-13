package org.bolat.util.collection.circularqueue;

import org.bolat.util.collection.CircularQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;
import java.util.stream.IntStream;

public class CircularQueueGetTest {

    @Test
    public void getItemSizeTest() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>();

        // then
        IntStream.range(0, 20).forEach(queue::putItem);

        IntStream.range(0, 20).forEach(value -> {
            Optional<Integer> val = queue.getItem();
            if (val.isPresent())
                System.out.println(val.get());
            else
                System.out.println("Empty");
        });

        // expected
        Assert.assertEquals(0, queue.size());
    }
}
