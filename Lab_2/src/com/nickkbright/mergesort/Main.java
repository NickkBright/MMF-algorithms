package com.nickkbright.mergesort;

import com.nickkbright.ArrayInit.ArrayInitialization;
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


    private static void ArrayMergeSort(int n) {
        System.out.println("Arrays are being sorted. Please stand by...");
        int[] arr = new int[ARRAY_LENGTH];
        for (int i = 0; i < n; i++) {
            initialize(arr);
            ArrayInitialization.writeFile(arr);
            ArrayInitialization.readFile(arr);
            ArrayInitialization.writeFile(MergeSort.mergeSort(arr));
        }
    }

    public static void main(String[] args) {
        ArrayMergeSort(10000);
    }

}