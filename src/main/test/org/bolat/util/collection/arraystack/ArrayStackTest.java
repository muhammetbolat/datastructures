package org.bolat.util.collection.arraystack;

import org.bolat.util.collection.ArrayStack;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class ArrayStackTest {
    @Test
    public void sizeTest() {
        // given
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        int expectedValue = 3;

        // then
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // expected
        Assert.assertEquals(expectedValue, stack.size());
    }

    @Test
    public void pushUntilLimitTest() {
        // given
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        int expectedValue = 3;

        // then
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);


        // expected
        Assert.assertTrue(stack.push(5));
        Assert.assertFalse(stack.push(6));
    }

    @Test
    public void popTest() {
        // given
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        Integer[] testList = {1, 2, 3};

        // then
        Arrays.stream(testList).forEach(stack::push);

        // expected
        Assert.assertEquals(stack.pop(), testList[2]);
        Assert.assertEquals(stack.pop(), testList[1]);
        Assert.assertEquals(stack.pop(), testList[0]);

        Assert.assertNull(stack.pop());
    }

    @Test
    public void isEmptyTest() {
        // given
        ArrayStack<Integer> stack = new ArrayStack<>(3);
        Integer[] testList = {1, 2, 3};

        // then
        Arrays.stream(testList).forEach(stack::push);

        System.out.println("Push Test");
        stack.walk(System.out::println);

        // expected
        System.out.println("Pop Test");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }

        Assert.assertTrue(stack.isEmpty());
    }
}
