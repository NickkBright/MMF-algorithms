package com.nickkbright.lab1.sort;

public class HybridSort {

    private static int number = 361;

    public static void hybridSort(int[] arr, int start, int end) {
        if ( end - start < number) {
            insertionSort(arr, start, end);
        } else {
            if (start < end) {
                int divider = QuickSort.partition(arr, start, end);
                hybridSort(arr, start, divider - 1);
                hybridSort(arr, divider + 1, end);
            }
        }
    }

    private static void insertionSort(int[] arr, int start, int end) {
        int current, j;

        for (int i = start + 1; i < end - 1; ++i) {
            current = arr[i];
            j = i - 1;

            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                --j;
            }

            arr[j + 1] = current;
        }
        }
}