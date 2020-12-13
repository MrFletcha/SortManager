package com.spartaglobal.jf;

import com.spartaglobal.jf.binarytree.GrowingBinaryTree;
import com.spartaglobal.jf.binarytree.Node;
import com.spartaglobal.jf.exceptions.ChildNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryTreeTester {

    Node node = new Node(3);
    GrowingBinaryTree growingTree = new GrowingBinaryTree(node);

    @Test
    void createAndFetchRootNode()
    {
        int root = growingTree.getRootElement();
        Assertions.assertEquals(3, root);
    }

    @Test
    void newNodeCanBeAddedAndFound()
    {
        Assertions.assertEquals(1, growingTree.getNumberOfElements());
        growingTree.addNodeToTree(node, 5);
        Assertions.assertEquals(2, growingTree.getNumberOfElements());
        growingTree.addNodeToTree(node, 2);
        Assertions.assertEquals(3, growingTree.getNumberOfElements());
        growingTree.addNodeToTree(node, 6);
        Assertions.assertEquals(4, growingTree.getNumberOfElements());
        Assertions.assertFalse(!growingTree.findElement(5));
    }

    @Test
    void areChildrenEmpty() throws ChildNotFoundException
    {
        growingTree.addNodeToTree(node, 8);
        growingTree.addNodeToTree(node, 9);
        growingTree.addNodeToTree(node, 10);
        Assertions.assertEquals(9, growingTree.getRightChild(8));
    }

    @Test
    void addingNodesByElementAndAsAnArray()
    {
        growingTree.addElement(2);
        Assertions.assertTrue(growingTree.findElement(2));

        int [] elementArr = new int[] {7, 8, 1, 9, 5, 6, 3};
        growingTree.addElements(elementArr);
        Assertions.assertEquals(8, growingTree.getNumberOfElements());
    }

    @Test
    void sortingTest()
    {
        int [] elementArr = new int[] {7, 8, 1, 9, 2, 16, 18, 4, 25};
        int [] elementArrPre = new int[] {1, 2, 3, 4, 7, 8, 9, 16, 18, 25};
        int [] elementArrDec = new int[] {25, 18, 16, 9, 8, 7, 4, 3, 2, 1};
        growingTree.addElements(elementArr);
        System.out.println(growingTree.getNumberOfElements());
        Assertions.assertEquals(Arrays.toString(elementArrPre), Arrays.toString(growingTree.getSortedTreeAsc()));
        Assertions.assertEquals(Arrays.toString(elementArrDec), Arrays.toString(growingTree.getSortedTreeDesc()));
    }

}
