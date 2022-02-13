package org.bolat.util.collection.circularqueue;

import org.bolat.util.collection.CircularQueue;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class CircularQueuePredicateTest {
    @Test
    public void findFirstTailBiggerThanHeadTest() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.putItem(1);
        queue.putItem(2);
        queue.putItem(2);
        queue.putItem(3);

        // then
        Optional<Integer> optionalResult = queue.findFirst(val -> val % 2 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(2, result);

    }

    @Test
    public void findLastTailBiggerThanHeadTest() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.putItem(1);
        queue.putItem(2);
        queue.putItem(2);
        queue.putItem(3);

        queue.walk(System.out::println);

        // then
        Optional<Integer> optionalResult = queue.findLast(val -> val % 2 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(2, result);

    }

    @Test
    public void findFirstHeadBiggerThanTailTest() {

        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);

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

        // then
        Optional<Integer> optionalResult = queue.findFirst(val -> val % 2 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(4, result);

    }


    @Test
    public void findLastHeadBiggerThanTailTest() {

        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);

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
        // then
        Optional<Integer> optionalResult = queue.findLast(val -> val % 2 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(4, result);

    }

    @Test
    public void findFirstNotMatch() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.putItem(1);
        queue.putItem(2);
        queue.putItem(2);
        queue.putItem(3);
        queue.putItem(3);

        // then
        Optional<Integer> optionalResult = queue.findFirst(val -> val % 7 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(-1, result);
    }

    @Test
    public void findLastNotMatch() {
        // given
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.putItem(1);
        queue.putItem(2);
        queue.putItem(2);
        queue.putItem(3);
        queue.putItem(3);

        // then
        Optional<Integer> optionalResult = queue.findLast(val -> val % 7 == 0);
        int result = optionalResult.isEmpty() ? -1: optionalResult.get();

        // expected
        Assert.assertEquals(-1, result);
    }
}
