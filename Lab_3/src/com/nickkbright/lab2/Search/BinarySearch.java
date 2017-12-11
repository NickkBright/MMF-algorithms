package com.nickkbright.lab2.Search;

public class BinarySearch {
    public static int binarySearch(int arr[], int l, int r, int x, int depth) {
        if (r >= l) {
            int mid = l + (r - l) / 2;
            // If the element is present at the middle itself
            if(arr[mid] == x) {
//                return mid;
                System.out.println("BS Position: " + mid);
                return depth;
            }
            // If element is smaller than mid, then it can only be present in left subArray

            if (arr[mid] > x) {
                depth++;
                return binarySearch(arr, l, mid-1, x, depth);
            }
            // Else the element can only be present in right subArray
            depth++;
            return binarySearch(arr, mid+1, r, x, depth);
        }
        // We reach here when element is not present in array
//        return -1;
        System.out.println("Position: -1");
        return depth;
    }
}