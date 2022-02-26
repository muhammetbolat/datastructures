package org.bolat.util.collection;

import java.util.Comparator;

public class BinarySearchTree<T> {
    public static class Node<T> {
        public final T value;
        public Node<T> left;
        public Node<T> right;

        public Node(T value) {
            this(value, null, null);
        }

        public Node(T value, Node<T> left, Node<T> right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private Node<T> root;
    private final Comparator<T> comparator;
    private int size = 0;

    private void traversalPut(Node<T> curNode, T item) {
        if (curNode.value == item)
            return;

        Node<T> nextNode;
        if (comparator.compare(item, curNode.value) < 0) {
            nextNode = curNode.left;
            if(nextNode == null)
                curNode.left = new Node<>(item);
            else
                traversalPut(nextNode, item); // recursion
        } else {
            nextNode = curNode.right;
            if (nextNode == null)
                curNode.right = new Node<>(item);
            else
                traversalPut(nextNode, item); // recursion
        }
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }


    public void insert(T item) {
        if (root == null)
            root = new Node<>(item);
        else
            traversalPut(root, item);
    }

    private Node<T> traversalGet(Node<T> curNode, T item) {
        Node<T> result;

        if(comparator.compare(item, curNode.value) < 0)
            result = traversalGet(curNode.left, item); // recursion
        else if(comparator.compare(item, curNode.value) > 0)
            result = traversalGet(curNode.right, item); // recursion
        else
            result = curNode;

        return result;
    }

    public Node<T> lookup(T item) {
        if (root == null)
            return null;

        return traversalGet(root, item);
    }






}
