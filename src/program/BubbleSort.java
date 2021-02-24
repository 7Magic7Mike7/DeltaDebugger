package program;

import java.util.Scanner;

public class BubbleSort
{
    public static void bubbleSort(Integer arr[], int n)
    {
        int i, j, temp;
        boolean swapped;

        for (i = 0; i < n - 1; i++)
        {
            swapped = false;

            //goes through array until last element which is at its right place
            for (j = 0; j < n - j - 1; j++)   // richtig=> j<n-i-1 ,  bug1=> j<n-i-2, bug2=> j<n-j-1
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF elements were not swapped then everything is already sorted
            if (swapped == false)
                break;
        }
    }

    static void printArray(int arr[])
    {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[])
    {   Scanner reader = new Scanner(System.in);
        String[] arrS;
        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

        //bubbleSort(arr, arr.length);
        System.out.println("Sorted array: ");
        printArray(arr);

    }
}

