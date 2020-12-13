package com.spartaglobal.jf.binarytree;

import com.spartaglobal.jf.Sorters.Sorter;
import com.spartaglobal.jf.exceptions.ChildNotFoundException;

public interface BinaryTree {

    int getRootElement();

    int getNumberOfElements();

    void addElements(final int[] elements);

    void addElement(final int element);

    boolean findElement(final int value);

    int getLeftChild(int element) throws ChildNotFoundException;

    int getRightChild(int element) throws ChildNotFoundException;

    int[] getSortedTreeAsc();

    int[] getSortedTreeDesc();

}
