package com.spartaglobal.jf.Sorters;

public class SelectionSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {


        int length = arrayToSort.length;
        int counter = length;
        int j = 0;

        for (int i = 0; i < length -1; i++) {
            int bigVal = 0;
            for(j = 0; j < counter; j++)
            {
                if(arrayToSort[bigVal] < arrayToSort[j])
                {
                    bigVal = j;
                }
            }
            int temp = arrayToSort[j - 1];
            arrayToSort[j - 1] = arrayToSort[bigVal];
            arrayToSort[bigVal] = temp;
            counter --;
        }
//
        return arrayToSort;
    }
}
