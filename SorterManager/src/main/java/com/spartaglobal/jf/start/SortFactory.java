package com.spartaglobal.jf.start;

import com.spartaglobal.jf.Sorters.*;
import com.spartaglobal.jf.binarytree.BinaryTree;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SortFactory {

    static Logger logger = LogManager.getLogger(SortFactory.class);

    public static Sorter sorterFactory(int n)
    {
        logger.debug("Getting new Object from the sort factory with Index of: " + n);

        switch(n)
        {
            case 1:
                logger.debug("Getting a new Object of type BubbleSort from the sort factory");
                return new BubbleSort();

            case 2:
                logger.debug("Getting a new Object of type MergeSort from the sort factory");
                return new MergeSort();

            case 3:
                logger.debug("Getting a new Object of type QuickSort from the sort factory");
                return new QuickSort();

            case 4:
                logger.debug("Getting a new Object of type InsertionSort from the sort factory");
                return new InsertionSort();

            case 5:
                logger.debug("Getting a new Object of type SelectionSort from the sort factory");
                return new SelectionSort();
        }
        return null;
    }
}
