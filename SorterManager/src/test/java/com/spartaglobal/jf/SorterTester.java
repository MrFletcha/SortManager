package com.spartaglobal.jf;

import com.spartaglobal.jf.Sorters.Sorter;
import com.spartaglobal.jf.exceptions.chosenValueNotIntException;
import com.spartaglobal.jf.start.SortFactory;
import com.spartaglobal.jf.userfacing.PrintingToUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SorterTester {

    public static Sorter sorter;
    public static PrintingToUser printer = new PrintingToUser();
    static Logger logger = LogManager.getLogger(SorterTester.class);

    @Test
    void checkAllSorterMethods()
    {
        int[] arr = new int[]{90, 60, 40, 50, 20, 100, 30, 23, 65, 101, 60};
        int[] sortedArr = new int[] {20,23, 30,40,50,60, 60, 65, 90,100, 101};
        for (int i = 1; i < 6; i++) {
            sorter = SortFactory.sorterFactory(i);
            Long start = System.nanoTime();
            Assertions.assertEquals(Arrays.toString(sortedArr), Arrays.toString(sorter.sortArray(arr)));
            Long finish = System.nanoTime();
            logger.debug("The " + sorter.getClass().getSimpleName() + " took: " + (finish - start) + "ms to complete");
        }

    }

    @Test
    void wrongInputCheck()  {

        try {
            sorter = SortFactory.sorterFactory(printer.printOptions());
            Assertions.fail();
        } catch (chosenValueNotIntException e) {
            Assertions.assertEquals("You failed to input a numerical value, so I guess me and you are done. Goodbye You!", e.getMessage());
        }

    }

}
