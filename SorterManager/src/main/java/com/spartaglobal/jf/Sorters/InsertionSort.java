package com.spartaglobal.jf.Sorters;

public class InsertionSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
//First we need to make i = 1 instead of 0 because we are checking the
// previous value against the current array value. If left at 0 this would
// create a outOfBoundsException for the while loop
        for(int i = 1; i < arrayToSort.length ;i++)
        {
            //key value created for the while loop to work against, then store as then insert where needed
            int keyVal = arrayToSort[i];
            //find the previous value of the array to compare with current value
            int prevVal = i -1;
            //this allows to both ensure the value is not below zero, which would cause an error I think...
            //but also allows us to make sure the key value is lower than the previous before inserting
            while(prevVal >= 0 && keyVal < arrayToSort[prevVal])
            {
                //while the key value is less than the previous value its going to set the value
                //one index above the current pre-value to = the current pre-value
                arrayToSort[prevVal+1] = arrayToSort[prevVal];
                //this then changes the current index we're checking in the while loop to
                //the one before and starts checking again
                prevVal = prevVal - 1;
            }
            //Once its established that the pre-value being checked is lower than the key value
            //this line changes the value above it to the key value, thus inserting it in the array.
            arrayToSort[prevVal+1] = keyVal;
        }
        return arrayToSort;
    }
}
