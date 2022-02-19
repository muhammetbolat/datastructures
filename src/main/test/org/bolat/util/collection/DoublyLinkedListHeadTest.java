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
public class DoublyLinkedListHeadTest {
    private final ArrayList<String> m_list;

    public DoublyLinkedListHeadTest(ArrayList<String> list) throws IOException {
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
    public void addItemHeadTest(){
        // given
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

        // then
        for (String strVal: m_list) {
            linkedList.addItemHead(strVal);
        }
        //linkedList.walkList(System.out::println);
        // expected
        assertEquals(linkedList.size(), m_list.size());
    }

    @Test
    public void removeHeadIsNull() {
        // given
        DoublyLinkedList<Integer> linkedList = new DoublyLinkedList<>();
        var result = linkedList.removeHead();

        // expected
        assertNull(result);
    }

    @Test
    public void removeHead() {
        // given
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

        // then
        for (String strVal: m_list) {
            linkedList.addItemHead(strVal);
        }


        String result = linkedList.removeHead();

        // expected
        assertEquals(result, m_list.get(m_list.size() - 1));
    }

    @Test
    public void findTheFirst() {
        // given
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();
        String actual = "Ali";

        // then
        for (String srtVal: m_list)
            linkedList.addItemHead(srtVal);

        Optional<String> result = linkedList.walkList(val -> val.length() == 3);

        assertTrue(result.isPresent());
        assertEquals(result.get(), actual);
    }

    @Test
    public void clear() {
        // given
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

        // then
        for (String strVal: m_list)
            linkedList.addItemHead(strVal);
        linkedList.clearFromHead();

        // expected
        assertEquals(0, linkedList.size());

    }

}
