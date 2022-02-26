package org.bolat.util.collection.tree;

import org.bolat.util.collection.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

public class BSTTest {
    @Test
    public void testInsertItem() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);

        bst.insert(50);
        bst.insert(30);
        bst.insert(40);
        bst.insert(20);
        bst.insert(100);
        bst.insert(40);

        Assert.assertTrue(true);

    }

    @Test
    public void testLookup() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);

        bst.insert(50);
        bst.insert(30);
        bst.insert(40);
        bst.insert(20);
        bst.insert(100);

        BinarySearchTree.Node<Integer> result = bst.lookup(30);

        Assert.assertEquals(30, result.value.intValue());

    }
}
