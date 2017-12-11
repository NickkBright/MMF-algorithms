package com.nickkbright.lab2.Search;

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int start, int end, int value, int depth) {
        if (arr[start] == value) {
            System.out.println("IS Position: " + start);
            return depth;
        } else if (!(arr[start]<=value && arr[end]>=value)) {
            System.out.println("IS -1");
            return depth;
        }
        int pos = start + (int)(((double)(end - start) / (arr[end] - arr[start])) * (value - arr[start]));
        if (arr[pos] == value) {
            System.out.println("IS Position: " + pos);
            return depth;
        } else if (arr[pos] < value) {
            depth++;
            return interpolationSearch(arr, pos + 1, end, value, depth);
        } else {
            depth++;
            return interpolationSearch(arr,  start, pos - 1, value, depth);
        }
    }
}