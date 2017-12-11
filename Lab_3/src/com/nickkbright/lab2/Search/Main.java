package com.nickkbright.lab2.Search;

import com.nickkbright.ArrayInit.ArrayInitialization;

import java.util.Arrays;
import java.util.Random;


public class Main {
    private static final int ARRAY_LENGTH = 100000;
    private static final int ARRAY_RANGE = 100000;

    private static void initialization (int[] arr)
    {
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++)
        {
            arr[i]=random.nextInt(ARRAY_RANGE);
        }
    }

    private static void SearchComparison (int n)
    {
        int[] arr = new int[ARRAY_LENGTH];
        int x = 1*3*5*1*9*9*8;
        System.out.println("\tComparison");


        for (int i = 0; i < n; i++)
        {
            initialization(arr);
            Arrays.sort(arr);
            ArrayInitialization.writeFile(arr);
            System.out.println("__________________________________________________");
            System.out.println("| i | BINARY SEARCH | INTERPOLATION SEARCH |");

            System.out.println("| " + i + " |\t" + BinarySearch.binarySearch(arr, 0, ARRAY_LENGTH-1, x, 0)+"\t|\t" +
                    InterpolationSearch.interpolationSearch(arr, 0, ARRAY_LENGTH-1, x, 0) + "\t|");
            System.out.println("__________________________________________________");
        }
    }

    public static void main (String[] args)
    {
        SearchComparison(10);
    }
}
