package com.nickkbright.lab1;

import com.nickkbright.lab1.sort.InsertionSort;
import com.nickkbright.lab1.sort.QuickSort;
import com.nickkbright.ArrayInit.ArrayInitialization;
import com.nickkbright.lab1.sort.HybridSort;

import java.util.Random;


public class Main {

    private static final int ARRAY_LENGTH = 361;
    private static final int NUMBER_RANGE = 100000;

    private static void initialize(int[] arr) {
        Random random = new Random();
        for (int i = 0; i < ARRAY_LENGTH; i++) {
            arr[i] = random.nextInt(2 * NUMBER_RANGE + 1) - NUMBER_RANGE;
        }
    }

    private static long QuickSortTime(int[] arr) {
        long start = System.nanoTime();
        QuickSort.quickSort(arr, 0, ARRAY_LENGTH - 1);
        long finish = System.nanoTime();
        long time = finish - start;
        return time;
    }

    private static long InsertionSortTime(int[] arr) {
        long start = System.nanoTime();
        InsertionSort.insertionSort(arr);
        long finish = System.nanoTime();
        long time = finish - start;
        return time;
    }

    private static long HybridSortTime(int[] arr) {
        long start = System.nanoTime();
        HybridSort.hybridSort(arr, 0, ARRAY_LENGTH - 1);
        long finish = System.nanoTime();
        long time = finish - start;
        return time;
    }

    private static void findHybridSortNumber(int n) {
        System.out.println("Arrays are being sorted. Please stand by...");
        int[] arr = new int[ARRAY_LENGTH];
        long QuickSortTime = 0;
        long InsertionSortTime = 0;
        long HybridSortTime = 0;
        for (int i = 0; i < n; i++) {
            initialize(arr);
            ArrayInitialization.writeFile(arr);
            QuickSortTime += QuickSortTime(arr);
            ArrayInitialization.readFile(arr);
            InsertionSortTime += InsertionSortTime(arr);
            ArrayInitialization.readFile(arr);
            HybridSortTime += HybridSortTime(arr);
        }
        System.out.println("Average QuickSort time:  " + QuickSortTime/n);
        System.out.println("Average InsertionSort time:  " + InsertionSortTime/n);
        System.out.println("Average HybridSort time: " + HybridSortTime/n);
    }

    public static void main(String[] args) {
        findHybridSortNumber(10000);
    }

}
