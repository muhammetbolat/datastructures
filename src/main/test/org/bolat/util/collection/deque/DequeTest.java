package org.bolat.util.collection.deque;

import org.bolat.util.collection.Deque;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class DequeTest {
    @Test
    public void addItemFirstTest() {
        // given
        Deque<Integer> deque = new Deque<>(2);
        int arraysize = 100;

        // then
        IntStream.range(0, arraysize).forEach(deque::addItemFirst);
        deque.walk(System.out::println);

        // expected
        Assert.assertEquals(deque.size(), arraysize);
    }

    @Test
    public void addItemTailTest() {
        //given
        Deque<Integer> deque = new Deque<>(2);
        int arraySize = 100;

        //then
        IntStream.range(0, arraySize).forEach(deque::addItemTail);
        deque.walk(System.out::println);

        // expected
        Assert.assertEquals(deque.size(), arraySize);
    }

    @Test
    public void addItemFirstAndTailTest() {
        //given
        Deque<Integer> deque = new Deque<>(2);
        int arraySize = 100;

        //then
        IntStream.range(0, arraySize).forEach(val -> {
            if (val % 2 == 0)
                deque.addItemFirst(val);
            else
                deque.addItemTail(val);
        });

        deque.walk(System.out::println);

        // expected
        Assert.assertEquals(deque.size(), arraySize);
    }


}
