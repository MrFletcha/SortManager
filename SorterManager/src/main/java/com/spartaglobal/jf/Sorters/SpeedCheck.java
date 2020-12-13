package com.spartaglobal.jf.Sorters;

import com.spartaglobal.jf.binarytree.GrowingBinaryTree;
import com.spartaglobal.jf.binarytree.Node;
import com.spartaglobal.jf.start.RandomIntsArray;
import com.spartaglobal.jf.start.SortFactory;
import com.spartaglobal.jf.userfacing.PrintingToUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class SpeedCheck {

    RandomIntsArray randomIntsArray = new RandomIntsArray();
    PrintingToUser printing = new PrintingToUser();
    Logger logger = LogManager.getLogger();

    public Long startTimer()
    {
        return System.nanoTime();
    }

    public Long endTimer()
    {
        return System.nanoTime();
    }

    public Long timeTaken(Long start, Long finish)
    {
        return finish - start;
    }

    public void speedCheckAll()
    {
        int[] userArray = randomIntsArray.randoms(50, 9);
        for (int i = 0; i < 6; i++)
        {
            Sorter sortingTime = SortFactory.sorterFactory(i);
            if(sortingTime!=null) {
                Long start = startTimer();
                userArray = sortingTime.sortArray(userArray);
                Long finish = endTimer();
                printing.printingResults(Arrays.toString(userArray), sortingTime.getClass().getSimpleName(), timeTaken(start,finish));
            }
        }
        treeSpeed();
    }

    public void treeSpeed()
    {
        Node node = new Node(9);
        GrowingBinaryTree growingBinaryTree = new GrowingBinaryTree(node);
        growingBinaryTree.addElements(randomIntsArray.randoms(50, 8));

        Long start = startTimer();
        String treeArr = Arrays.toString(growingBinaryTree.getSortedTreeAsc());
        Long finish = endTimer();
        printing.printingResults(treeArr, "BinaryTreeSort Asc", timeTaken(start, finish));

        start = startTimer();
        treeArr = Arrays.toString(growingBinaryTree.getSortedTreeDesc());
        finish = endTimer();
        printing.printingResults(treeArr, "BinaryTreeSort Asc", timeTaken(start, finish));
    }
}
