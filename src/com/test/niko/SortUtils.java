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
        for (int i = 1; i < arr.length; ++i) {
            int tmp = arr[i];
            int j = i -1;
            for (; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }
}
