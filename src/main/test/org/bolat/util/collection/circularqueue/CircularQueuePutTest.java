package org.bolat.util.collection.circularqueue;

import org.bolat.util.collection.CircularQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class CircularQueuePutTest {

    @Test
    public void addNewItemSizeTest() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>();

        // then
        IntStream.range(0, 20).forEach(queue::putItem);
        int size = queue.size();

        // expected
        Assert.assertEquals(10, size);
    }
}
