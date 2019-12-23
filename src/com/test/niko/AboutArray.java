package com.test.niko;

/**
 * Created by nikoliu on 2019/12/16.
 */
public class AboutArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        while (i < n) {
            nums1[m + i] = nums2[i];
            ++i;
        }
        charu(nums1);
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

    public static int findMaxValueArr(int nums[]) {
        int value = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];
            if (value < start) {
                value = start;
            }
            for (int j = i + 1; j < nums.length; j++) {
                start += nums[j];
                if (value < start) {
                    value = start;
                }
            }
        }
        return value;
    }

    public static int findMaxValueArr1(int nums[]) {
        int value = nums[0];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res += nums[i];
            if (res > value) {
                value = res;
            }
            if (res < 0) {
                res = 0;
            }
        }
        return value;
    }
}
