package com.test.niko;

import sun.misc.Unsafe;

import java.util.Stack;

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

    //括号正确性
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char i : s.toCharArray()) {
            if (i == '[' || i == '{' || i == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.peek();
                if (i == ']' && top == '['){
                    stack.pop();
                }
                else if (i == '}' && top == '{'){
                    stack.pop();
                }
                else if (i == ')' && top == '('){
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    //是否回文数字
    public static boolean isPalindrome(int num) {
        if (num < 0) {
            return false;
        }
        String str = num + "";
        int i = 0;
        int j = str.length() - 1;
        int end = (str.length() - 1)/2;
        while (i <= end && j >= end) {
            char a = str.charAt(i);
            char b = str.charAt(j);
            if (a != b) {
                return false;
            }
            --j;
            ++i;
        }
        return true;
    }





    public static int lengthOfLastWord(String s) {
        int i = s.length() - 1;
        int count = 0;
        if (s.equals(" ") || s.equals("")) {
            return count;
        }
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                i--;
                continue;
            }
            break;
        }
        while (i >= 0) {
            if (s.charAt(i) != ' '){
                count++;
                --i;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
