package org.bolat.util.collection;

import java.util.LinkedList;

@SuppressWarnings("unchecked")
public class HashMap<K, V> {

    private class Node<K, V> {
        private final K key;
        private V value;
        private Node<K, V> next;

        public Node(K key, V value, Node<K, V> node) {
            this.key = key;
            this.value = value;
            this.next = node;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /*
    private int hash(K key) {
        int hashVal = 0;
        for (int i = 0; i < value.length(); i++)
            hashVal += value.charAt(i) * i;
        return hashVal % list.length;
    }

     */

}
