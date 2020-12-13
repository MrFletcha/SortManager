package com.spartaglobal.jf.userfacing;

import com.spartaglobal.jf.exceptions.chosenValueNotIntException;
import com.spartaglobal.jf.start.SortFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Scanner;

public class PrintingToUser {

    Scanner scanner = new Scanner(System.in);
    static Logger logger = LogManager.getLogger(PrintingToUser.class);

    public int printOptions() throws chosenValueNotIntException
    {
        logger.debug("Start menu printed for user");
        int num = 0;
        System.out.println("Hello You!");
        System.out.println("-------------");
        System.out.println("Here's what we have on offer.");
        System.out.println("1. BubbleSort");
        System.out.println("2. MergeSort");
        System.out.println("3. QuickSort");
        System.out.println("4. InsertionSort");
        System.out.println("5. SelectionSort");
        System.out.println("6. BinaryTreeSort Ascending");
        System.out.println("7. BinaryTreeSort Descending");
        System.out.println("8. Do a speed Test on all Sorts");
        System.out.print("Please enter a number for which sort you would like to do: ");

        if(!scanner.hasNextInt()) {throw new chosenValueNotIntException();}

        num = scanner.nextInt();

        return num;
    }

    public int getMaxValue() throws chosenValueNotIntException
    {
        logger.debug("Taking Value for maximum array value");
        System.out.print("Please enter the maximum value you would like in your array: ");
        if(!scanner.hasNextInt()) {throw new chosenValueNotIntException();}
        int n = scanner.nextInt();
        return n;
    }

    public int getArrayLength() throws chosenValueNotIntException
    {
        logger.debug("Value request for Array Length");
        System.out.print("Please enter the number of values you'd like in your array: ");
        if(!scanner.hasNextInt()) {throw new chosenValueNotIntException();}
        int n = scanner.nextInt();
        return n;
    }

    public void printingResults(String array, String sortType, Long timeTaken)
    {
        logger.debug("Results printed with input values of a sorted user array: " + array + " and the type of sorting selected: " + sortType);
        System.out.println("That's all done for you using the: " + sortType);
        System.out.println("Your sorted array: " + array);
        System.out.println("Time taken: " + timeTaken + "ns");
    }

    public void printUnsortedArray(int[] array)
    {
        logger.debug("Unsorted array printed to show starting point of method.");
        System.out.println("Your original unsorted array is: "+ Arrays.toString(array) + ". Just in case you were wondering.");
    }
}
