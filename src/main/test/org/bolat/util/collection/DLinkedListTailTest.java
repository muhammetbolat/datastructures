package org.bolat.util.collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DLinkedListTailTest {
    private final ArrayList<String> m_list;

    public DLinkedListTailTest(ArrayList<String> list) throws IOException {
        m_list = list;
        try(var bw = Files.newBufferedWriter(Path.of("test.txt"))) {
            for (String val: list)
                bw.write(val + "\r\n");
        }
    }

    @Parameterized.Parameters
    public static Collection<ArrayList<String>> createData() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas"); add("Semih");}});
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas"); add("Semih"); add("Bahattin");}});
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas");}});
        return data;
    }

    @Test
    public void addItemTailTest(){
        // given
        DLinkedList<String> linkedList = new DLinkedList<>();

        // then
        for (String strVal: m_list) {
            linkedList.addItemTail(strVal);
        }

        // expected
        assertEquals(linkedList.size(), m_list.size());
    }

    @Test
    public void removeTailIsNull() {
        // given
        DLinkedList<Integer> linkedList = new DLinkedList<>();
        var result = linkedList.removeTail();

        // then

        // expected
        assertNull(result);
    }

    @Test
    public void removeTail() {
        // given
        DLinkedList<String> linkedList = new DLinkedList<>();

        // then
        for (String strVal: m_list) {
            linkedList.addItemTail(strVal);
        }


        String result = linkedList.removeTail();

        // expected
        assertEquals(result, m_list.get(m_list.size() - 1));
    }

    @Test
    public void findTheFirst() {
        // given
        DLinkedList<String> linkedList = new DLinkedList<>();

        // then
        for (String srtVal: m_list)
            linkedList.addItemHead(srtVal);

        Optional<String> result = linkedList.walkListReversed(val -> val.length() == 3);

        assertTrue(result.isPresent());
        assertEquals(result.get(), "Can");
    }

    @Test
    public void clear() {
        DLinkedList<String> linkedList = new DLinkedList<>();

        // then
        for (String srtVal: m_list)
            linkedList.addItemHead(srtVal);

        linkedList.clearFromTail();

        assertEquals(0, linkedList.size());
    }

}
