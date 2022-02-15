package org.bolat.util.collection;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LinkedListQueueTest {
    @Test
    public void addItemTest() {
        //given
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        List<String> nameList = new ArrayList<>(){{add("ali"); add("bahattin"); add("cafer"); add("dursun");}};
        int actualSize = nameList.size();

        nameList.forEach(linkedListQueue::putItem);

        // then
        int size = linkedListQueue.size();

        // expected
        Assert.assertEquals(size, actualSize);
    }

    @Test
    public void getItemTest() {
        //given
        LinkedListQueue<String> linkedListQueue = new LinkedListQueue<>();
        List<String> nameList = new ArrayList<>(){{add("ali"); add("bahattin"); add("cafer"); add("dursun");}};
        List<String> outputList = new ArrayList<>();
        nameList.forEach(linkedListQueue::putItem);

        // then
        IntStream.range(0, linkedListQueue.size()).forEach(i -> outputList.add(linkedListQueue.getItem()));

        // expected
        Assert.assertEquals(nameList.get(0), outputList.get(0));
        Assert.assertEquals(nameList.get(1), outputList.get(1));
        Assert.assertEquals(nameList.get(2), outputList.get(2));
        Assert.assertEquals(nameList.get(3), outputList.get(3));

    }
}
