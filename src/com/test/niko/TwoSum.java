package com.test.niko;

import java.util.*;
import java.util.concurrent.*;
import java.util.zip.Adler32;

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

    public static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] += 1;
            return digits;
        }
        int []res = digits;
        if (digits[0] == 9) {
            res = new int[digits.length + 1];
            res[0] = 0;
            for (int i = 0; i < digits.length; i++) {
                res[i+1] = digits[i];
            }
        }
        int add = 1;
        for (int i = res.length - 1; i >= 0; --i) {
            res[i] += add;
            if (res[i] > 9) {
                add = 1;
                res[i] -= 10;
                continue;
            } else {
                return res;
            }
        }
        return res;
     }

    public static String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int indexA = a.length();
        int indexB = b.length();
        int add = 0;
        while (indexA > 0 && indexB > 0) {
            --indexA;
            --indexB;
            int aValue = a.charAt(indexA) - '0';
            int bValue = b.charAt(indexB) - '0';
            int temp = aValue + bValue + add;
            add = temp > 1 ? 1 : 0;
            if (add == 0) {
                sb.append(temp);
            } else {
                sb.append(temp - 2);
            }
        }
        while (indexA > 0) {
            --indexA;
            int aValue = a.charAt(indexA) - '0';
            int temp = aValue + add;
            add = temp > 1 ? 1 : 0;
            if (add == 0) {
                sb.append(temp);
            } else {
                sb.append(temp - 2);
            }
        }
        while (indexB > 0) {
            --indexB;
            int bValue = b.charAt(indexB) - '0';
            int temp = bValue + add;
            add = temp > 1 ? 1 : 0;
            if (add == 0) {
                sb.append(temp);
            } else {
                sb.append(temp - 2);
            }
        }
        if (add == 1) {
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    public static int mySqrt(int x) {
        int i = 1;
        while (i < x/i) {
            ++i;
        }
        if (i == x/i) {
            return i;
        }
        return --i;
    }

    public static int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        return function(n, map);
    }

    public static int function(int n, Map<Integer, Integer> map) {
        if (n == 1) {
            map.put(1, 1);
            return 1;
        }
        if (n == 2) {
            map.put(2, 2);
            return 2;
        }
        if (map.get(n - 1) == null && map.get(n - 2) == null) {
            map.put(n - 1, function(n - 1, map));
            map.put(n - 2, function(n - 2, map));
        }
        return map.get(n - 1) + map.get(n - 2);
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        Set<Integer> set = new HashSet();
        ListNode tmp = head;
        set.add(head.val);
        while (tmp.next != null) {
            ListNode next = tmp.next;
            if (!set.contains(next.val)) {
                set.add(next.val);
                tmp = tmp.next;
            } else {
                tmp.next = next.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);
        listNode.next.next = new ListNode(2);
        listNode.next.next.next = new ListNode(3);
        listNode.next.next.next.next = new ListNode(3);
        listNode = deleteDuplicates(listNode);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
