package org.bolat.util.collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DLinkedListInsertItem {
    private final ArrayList<String> m_list;
    private DLinkedList<String> linkedList;

    public DLinkedListInsertItem(ArrayList<String> list) {
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
        linkedList = new DLinkedList<>();
        m_list.forEach(linkedList::addItemTail);
    }
    @Test
    public void clearTest() {
        // given

        // then
        linkedList.clear();

        // expected
        assertEquals(linkedList.size(), 0);
    }
}
