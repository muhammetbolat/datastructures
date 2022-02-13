package org.bolat.util.collection.circularqueue;

import org.bolat.util.collection.CircularQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class CircularQueueWalkTest {
    @Test
    public void addWalkTest() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);

        // then
        queue.putItem(0);
        queue.putItem(1);
        queue.putItem(2);
        queue.putItem(3);

        queue.getItem();
        queue.getItem();
        queue.getItem();
        queue.getItem();
        queue.getItem();
        queue.getItem();
        queue.getItem();

        queue.putItem(4);
        queue.putItem(5);

        queue.walk(System.out::println);

        // expected
        Assert.assertEquals(2, queue.size());
    }
}
