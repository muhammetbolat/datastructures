package org.bolat.util.collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.function.Consumer;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DoublyLinkedListDeleteItemTest {

    private final ArrayList<String> m_list;
    private DoublyLinkedList<String> linkedList;

    public DoublyLinkedListDeleteItemTest(ArrayList<String> list) {
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
    public void insertItemTest() {
        // given
        Random random = new Random();
        int randomIndex = random.nextInt(linkedList.size());

        // then
        //linkedList.walkList((Consumer<String>) System.out::println);
        linkedList.insertItem(randomIndex, "Bolat");

        String val = linkedList.get(randomIndex);

        linkedList.walkList((Consumer<String>) System.out::println);


        // expected
        assertEquals(val, m_list.get(randomIndex));
    }


}
