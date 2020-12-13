package com.spartaglobal.jf.binarytree;

import com.spartaglobal.jf.exceptions.ChildNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GrowingBinaryTree implements BinaryTree {

    private final Node rootNode;
    static Logger logger = LogManager.getLogger(GrowingBinaryTree.class);
    int[] arrA, arrD;
    int i = 0;
    int j = 0;

    public GrowingBinaryTree(Node rootNode) {
        logger.debug("Tree created");
        this.rootNode = rootNode;
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {

        Node node = rootNode;
        if (node == null) {
            logger.debug("Node has a value of null on get number of elements");
            return 0;
        }

        int nodeCount = 0;
        while (node != null) {
            if (node.getLeftChild() != null) {
                nodeCount++;
                logger.debug(node.getLeftChild().getValue());
            }
            if (node.getRightChild() != null) {
                logger.debug(node.getRightChild().getValue());
            }
            node = node.getRightChild();
            nodeCount++;
        }

        node = rootNode.getLeftChild();
        if (node != null) {
            nodeCount--;
        }
        while (node != null) {
            nodeCount++;
            if (node.getRightChild() != null) {
                nodeCount++;
            }
            node = node.getLeftChild();
        }
        return nodeCount;
    }

    @Override
    public void addElements(int[] elements) {
        for (int e : elements) {
            addElement(e);
        }
    }

    public void addElement(final int element) {
        logger.debug("Elements Added");
        addNodeToTree(rootNode, element);
    }

    @Override
    public boolean findElement(int element) {
        Node node = rootNode;
        while (rootNode != null) {
            if (node.getValue() == element) {
                return true;
            }
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return false;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {

        Node node = rootNode;
        while (node.getValue() != element) {
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        if (node == null) {
            throw new ChildNotFoundException();
        }
        return node.getLeftChild().getValue();
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {

        Node node = rootNode;
        while (node.getValue() != element) {
            if (element < node.getValue()) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        if (node == null) {
            throw new ChildNotFoundException();
        }
        return node.getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        i = 0;
        this.arrA = new int[9];
        gettingAllValuesAsc(rootNode);
        return arrA;
    }

    @Override
    public int[] getSortedTreeDesc() {
        j = 0;
        this.arrD = new int[9];
        logger.debug("Length of array is: " + this.arrD.length);
        gettingAllValuesDec(rootNode);
        return arrD;
    }

    public void addNodeToTree(Node rootNode, int element) {
        logger.debug("Node being added");
        if (element <= rootNode.getValue()) {
            if (rootNode.isLeftChildEmpty()) {
                rootNode.setLeftChild(new Node(element));
            } else {
                addNodeToTree(rootNode.getLeftChild(), element);
            }
        } else if (element > rootNode.getValue()) {
            if (rootNode.isRightChildEmpty()) {
                rootNode.setRightChild(new Node(element));
            } else {
                addNodeToTree(rootNode.getRightChild(), element);
            }
        }
    }

    public void gettingAllValuesAsc(Node node)
    {
        if(node != null)
        {
            gettingAllValuesAsc(node.getLeftChild());
            addToArrA(node);
            gettingAllValuesAsc(node.getRightChild());
        }
    }

    public void gettingAllValuesDec(Node node)
    {
        if(node != null)
        {
            gettingAllValuesDec(node.getRightChild());
            addToArrD(node);
            gettingAllValuesDec(node.getLeftChild());
        }
    }

    public void addToArrA(Node node)
    {
        if(node!=null)
        {
            arrA[i] = node.getValue();
            i++;
        }
    }
    public void addToArrD(Node node)
    {
        logger.debug(node.getValue());
        if(node!=null)
        {
            arrD[j] = node.getValue();
            j++;
        }
    }

}


