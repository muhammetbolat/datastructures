package org.bolat.util.collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DlinkedListInsertItemTest {
    private final ArrayList<String> m_list;
    private DoublyLinkedList<String> linkedList;

    public DlinkedListInsertItemTest(ArrayList<String> list) {
        m_list = list;
    }

    @Parameterized.Parameters
    public static Collection<ArrayList<String>> createData() {
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas"); add("Semih");}});
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas"); add("Semih"); add("Bahattin");}});
        data.add(new ArrayList<>(){{add("Muhammet"); add("Can"); add("Ali"); add("Kostas");}});
        return data;
    }

    @Before
    public void setUp() {
        linkedList = new DoublyLinkedList<>();
        m_list.forEach(linkedList::addItemTail);
    }
    @Test
    public void clearTest() {
        // given

        // then
        linkedList.clear();

        // expected
        assertEquals(0, linkedList.size());
    }
}
