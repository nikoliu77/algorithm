package com.test.niko;

/**
 * Created by nikoliu on 2019/11/19.
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int arr[] = new int[2];
        int second = -1;
        int first = -1;
        for (int i = 0; i < nums.length; ++i) {
            int tmp = target - nums[i];
            for (int j = 0; j < nums.length; ++j) {
                if (i != j && nums[j] == tmp) {
                    first = i;
                    second = j;
                }
            }
        }
        if (second != -1 && first != -1) {
            arr[0] = first;
            arr[1] = second;
        }
        return arr;
    }

    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int res[] = twoSum(arr, 9);
        for (int i : res) {
            System.out.println(i);
        }
    }
}
