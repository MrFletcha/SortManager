package com.spartaglobal.jf.Sorters;

public class MergeSort implements Sorter {

    @Override
    public int[] sortArray(int[] arrayToSort) {

        splitSort(arrayToSort, arrayToSort.length);

        return arrayToSort;
    }

    public void splitSort(int[] arrayToSort, int length)
    {
        if(length < 2) {return;}
        {
            int m = length / 2;
            //Finds the middle value so it can divide the array into two

            int[] leftSide = new int[m];
            //makes the left array size up to the middle

            int[] rightSide = new int[length - m];
            //creates the right array size by getting the difference between the middle and length

            //Adds all values up to the middle into the left array
            for(int i = 0 ; i < m ; i++)
            {
                leftSide[i] = arrayToSort[i];
            }
            //Adds all values from the middle up to the end inside the array
            for(int j = m ; j < length; j++)
            {
                //Avoids an array out of bounds exception by reducing the j within the bounds of
                //the smaller right array, while also adding the correct values to it.
                rightSide[j - m] = arrayToSort[j];
            }

            splitSort(leftSide, m);

            splitSort(rightSide, length - m);

            mergeIt(arrayToSort, rightSide, leftSide, m, length - m);
        }
    }

    public void mergeIt(int[] arrayToSort, int[] r, int[] l, int lN, int hN)
    {
        //base values needed for comparison and incrementation of array index
        int i = 0;
        int j = 0;
        int k = 0;

        //while the integers sent are higher than base values we can compare each value
        //using a while loop also allows for any values to be placed in the ln hn positions
        //and still increment to the end of any array sent
        while (i < lN && j < hN) {

            // checks if the arrays left value is less than or equal to the right
            if (l[i] <= r[j])
                //K increments along with the array position to ensure the value is moved to the
                // correct location for the placement of the lower value
                arrayToSort[k++] = l[i++];
            else
                //otherwise its assumed the value is higher, so needs to go on the right side of
            //the array.
                arrayToSort[k++] = r[j++];
        }

        //as i is now greater than the lower num, its assumed the right value has moved to the left
        //which means the left value can now move into the right position dictated by K's value
        //which has incremented higher in the above while loop, this needed to be the case due to a
        // value bing swapped to K's original position. So the position after is what needs filling.
        while (i < lN)
            arrayToSort[k++] = l[i++];

        //the opposite is true for a left increment, which means a value has been placed on the left
        //so k will be to the right of it, placing the higher value from the right array into place
        while (j < hN)
            arrayToSort[k++] = r[j++];

    }
}
