package com.spartaglobal.jf.Sorters;

public class BubbleSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        boolean isNumSwapped;
        for (int i = 0; i < arrayToSort.length - 1; i++) {

            isNumSwapped = false;
            for (int j = 0; j < arrayToSort.length - 1; j++) {

                if (arrayToSort[j] > arrayToSort[j + 1]) {
                    var temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = temp;
                    isNumSwapped = true;
                }
            }

            if (isNumSwapped == false) {
                break;
            }
        }
        return arrayToSort;
    }
}
