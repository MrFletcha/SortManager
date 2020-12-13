# SortManager

I have developed this Java project to help better understand a multitude of sorting algorthms, but to also pass this understanding on to anyone that whats to know.

Sorts Available

BubbleSort
InsertionSort
MergeSort
QuickSort
SelectionSort
BinaryTreeSort Asc
BinaryTreeSort Dec
I have also given the ability to test all version of the sorts against one another with the same array, do you want to find out which one is faster?

Here's how

Start the app class, this will leave with a list of options in the console window.
Select one of these options and press enter, this will select the sort type you want from the sortFactory.
You will then be asked to pass in parameters for the maximum value you'd like in the array, but also the length you want the array to be.
Then we start sorting
The results will provide you with the unsorted array, the sorted array, the sorting type selected and the time it took to complete the sort
This is where the program ends and you can run it again to test any of the other sorting types
The patterns used in this development have been the factory pattern, defensive programming and some TDD(Test Driven Development)

As a side note, the arrays are different each time as they are randomly generated. This is also true for the binary tree sort, but the values and size predetermined upon the first instance of the GrowingBinaryTree class.

Please feel free to play with and break this code. I'm open to any advice on improvement, but only constructive criticisms please.
