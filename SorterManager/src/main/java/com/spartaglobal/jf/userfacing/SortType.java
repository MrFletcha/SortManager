package com.spartaglobal.jf.userfacing;

import com.spartaglobal.jf.Sorters.Sorter;
import com.spartaglobal.jf.binarytree.GrowingBinaryTree;
import com.spartaglobal.jf.binarytree.Node;
import com.spartaglobal.jf.exceptions.chosenValueNotIntException;
import com.spartaglobal.jf.Sorters.SpeedCheck;
import com.spartaglobal.jf.start.SortFactory;
import com.spartaglobal.jf.start.RandomIntsArray;

import java.util.Arrays;

public class SortType {

     public static void sorting()
    {
        RandomIntsArray randomIntsArray = new RandomIntsArray();
        PrintingToUser printing = new PrintingToUser();
        SpeedCheck speed = new SpeedCheck();

        int chosenValue = 0;
        try {
            chosenValue = printing.printOptions();
        } catch (chosenValueNotIntException e) {
            System.out.println(e.getMessage());
        }

        if(chosenValue >= 1 && chosenValue < 6 || chosenValue == 8) {

            int[] userArray = null;
            int[] unsorted = null;
            try {
                unsorted = randomIntsArray.randoms(printing.getMaxValue(), printing.getArrayLength());
                printing.printUnsortedArray(unsorted);
                userArray = unsorted;

            } catch (chosenValueNotIntException e)
            {
                System.out.println(e.getMessage());
            }

            if(chosenValue!=8)
            {
                Sorter sortingTime = SortFactory.sorterFactory(chosenValue);
                Long start = speed.startTimer();
                userArray = sortingTime.sortArray(userArray);
                Long finish = speed.endTimer();
                printing.printingResults(Arrays.toString(userArray), sortingTime.getClass().getSimpleName(), speed.timeTaken(start, finish));
            }
            else {
                speed.speedCheckAll();
            }

        }
        else if (chosenValue == 6 || chosenValue == 7)
        {
            Node node = new Node(9);
            GrowingBinaryTree growingBinaryTree = new GrowingBinaryTree(node);
            growingBinaryTree.addElements(randomIntsArray.randoms(50, 8));

            if(chosenValue == 6)
            {
                Long start = speed.startTimer();
                String treeArr = Arrays.toString(growingBinaryTree.getSortedTreeAsc());
                Long finish = speed.endTimer();
                printing.printingResults(treeArr, "BinaryTreeSort Asc", speed.timeTaken(start, finish));
            }
            else
                {
                Long start = speed.startTimer();
                String treeArr = Arrays.toString(growingBinaryTree.getSortedTreeDesc());
                Long finish = speed.endTimer();
                printing.printingResults(treeArr, "BinaryTreeSort Asc", speed.timeTaken(start, finish));
            }
        }
    }
}
