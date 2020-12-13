package com.spartaglobal.jf.Sorters;

public class QuickSort implements Sorter{

    @Override
    public int[] sortArray(int[] arrayToSort) {
        int last = arrayToSort.length -1;
        int first = 0;
        //from a random Array we create the first and last values and push them into the method below
        sort(arrayToSort, first, last);

        //returns changed array
        return arrayToSort;
    }

    public static int pivotShift(int[] arrayToSort, int n1, int n2)
    {
        //grab the middle or left of middle value as I have now learned
        int pivot = arrayToSort[n2];
        //starts a counter that increments after the for loop has started for the lower value selection
        int k = n1-1;
        //Starts the traversal of the array using the start point and length
        for (int j = n1; j < n2 ; j++)
        {
            //checks that the current element is smaller than the pivot
            if (arrayToSort[j] < pivot)
            {
                //swap values
                k++;
                int temp = arrayToSort[j];
                arrayToSort[j] = arrayToSort[k];
                arrayToSort[k] = temp;
            }
        }

        int temp = arrayToSort[k+1];
        arrayToSort[k+1] = arrayToSort[n2];
        arrayToSort[n2] = temp;
        return k+1;
    }

    void sort(int[] array, int n1, int n2)
    {
        if (n1 < n2) {
            //shifts the pivot point into the middle so array that is 20 40 30 25 60 would become 20 25 30 40 60
            int pivot = pivotShift(array, n1, n2);

            //sorts bottom half of the array by using the last pivot point to find the original pivot value,
            //then find the value before and sorts to index 0, this is because it can be assumed that anything
            //below the pivot is less than the pivots value. It also decrements the larger value until its equal to the lower
            //value, in this way providing a stopping point for its self
            sort(array, n1, pivot - 1);
            //sorts upper half of the array from one above the pivot point, incrementing the lower value until its equal with
            //the largest index before it stops. This is because we can assume that everything to right of the original pivot value is higher
            sort(array, pivot + 1, n2);
        }
    }

}
