package com.test.niko;

import sun.misc.Unsafe;

/**
 * Created by nikoliu on 2019/11/19.
 */
public class Algorithm {
    //输入数字输出字符串
    public static String swapIntToString(int num) {
        String str = "";
        while (num != 0) {
            str += num % 10;
            num /= 10;
        }
        return reserveString(str);
    }

    //字符串反转
    public static String reserveString(String str) {
        char arr[] =  str.toCharArray();
        int start = str.length() / 2;
        int step = 1;
        while (step <= start) {
            char tmp = arr[start - step];
            arr[start - step] = arr[start + step];
            arr[start + step] = tmp;
            step++;
        }
        return new String(arr);
    }

    //数组合并
    public static int[] mergeArr(int a[], int b[]) {
        int c[] = new int[a.length + b.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] > b[j]) {
                c[k++] = b[j++];
            } else {
                c[k++] = a[i++];
            }
        }
        while (i < a.length)
            c[k++] = a[i++];
        while (j < b.length)
            c[k++] = b[j++];
        return c;
    }

    public static void main(String[] args) {
        int a[] = {1, 2, 3};
        int b[] = {4, 5, 6};
        int c[] = mergeArr(a, b);
        for (int x : c) {
            System.out.println(x);
        }
        System.out.println(Unsafe.getUnsafe().arrayBaseOffset(c.getClass()));
    }
}
