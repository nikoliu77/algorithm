package com.test.niko;

/**
 * Created by nikoliu on 2019/11/18.
 */
public class SortUtils {
    public static int[] maopao(int arr[]) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static int[] xuanzhe(int arr[]) {
        for (int i = 0; i < arr.length; ++i) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length; ++j) {
                if (arr[j] < min) {
                    min = arr[j];
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static int[] charu(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
        return arr;
    }

    public static int getNewIndex(int arr[], int start, int end) {
        int tmp = arr[start];
        while (start < end) {
            while (end > start && arr[end] > tmp) {
                --end;
            }
            if (start < end) {
                arr[start] = arr[end];
                start++;
            }
            while (start < end && arr[start] < tmp) {
                start++;
            }
            if (start < end) {
                arr[end] = arr[start];
                end--;
            }
        }
        arr[start] = tmp;
        return start;
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int index = getNewIndex(arr, start, end);
            quickSort(arr, 0, index - 1);
            quickSort(arr, index + 1, end);
        }
    }
}
