package com.test.niko;

import java.io.*;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by nikoliu on 2019/11/18.
 */
public class Test {
    public static void testLinkList() {
        LinkList linkList = new LinkList(1);
        linkList.addNode(new LinkList(2));
        linkList.addNode(new LinkList(3));
        linkList.addNode(new LinkList(4));
        linkList.addNode(new LinkList(5));
        linkList = rerverse(linkList);
        while (linkList != null) {
            System.out.println(linkList.value);
            linkList = linkList.next;
        }
    }

    public static LinkList rerverse(LinkList linkList) {
        LinkList pre = null;
        while (linkList != null) {
            LinkList tmp = linkList;
            linkList = linkList.next;
            tmp.next = pre;
            pre = tmp;
        }
        return pre;
    }

    public static void testSort() {
        int arr[] = {2, 1, 3, 8, 5, 9, 6, 0, 7, 10};
        SortUtils.quickSort(arr, 0, arr.length -1);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void testSort1() {
        int arr[] = {2, 1, 3, 8, 5, 9, 6, 0, 7, 10};
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    public static void testTree() {
        TreeNode treeNode = new TreeNode("root");
        treeNode.setLeft(new TreeNode("a"));
        treeNode.getLeft().setLeft(new TreeNode("b"));
        treeNode.getLeft().setRight(new TreeNode("c"));
        treeNode.setRight(new TreeNode("d"));
        treeNode.getRight().setLeft(new TreeNode("e"));
        treeNode.getRight().setRight(new TreeNode("f"));
        List<String> res = new ArrayList<>();
        treeNode.preScan(res, treeNode);
        for (String s : res) {
            System.out.println(s);
        }
    }

    public static void testTree1() {
        TreeNode treeNode = new TreeNode("root");
        treeNode.setLeft(new TreeNode("a"));
        treeNode.getLeft().setLeft(new TreeNode("b"));
        treeNode.getLeft().setRight(new TreeNode("c"));
        treeNode.setRight(new TreeNode("d"));
        treeNode.getRight().setLeft(new TreeNode("e"));
        treeNode.getRight().setRight(new TreeNode("f"));
        StringBuilder sb = new StringBuilder();
        treeNode.preSearch(sb, treeNode);
        System.out.println(sb);
    }

    public static void sort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int index = index(arr, start, end);
        sort(arr, 0, index -1);
        sort(arr, index + 1, end);
    }

    public static int index(int arr[], int start, int end) {
        int swap = arr[start];
        while (end > start) {
            while (end > start && arr[end] > swap) {
                end--;
            }
            arr[start] = arr[end];
            start++;
            while (end > start && arr[start] < swap) {
                start ++;
            }
            arr[end] = arr[start];
            end--;
        }
        arr[start] = swap;
        return swap;
    }

    public static int computeIndex(int arr[],  int start, int end) {
        int swap = arr[start];
        while (start < end) {
            while (start < end && arr[end] > swap) {
                --end;
            }
            arr[start] = arr[end];
            start++;
            while (start < end && arr[start] < swap) {
                start++;
            }
            arr[end] = arr[start];
            end--;
        }
        arr[start] = swap;
        return swap;
    }

    public static void sort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int temp = arr[i];
            while (j >= 0) {
                if (arr[j] > temp) {
                    arr[j + 1] = arr[j];
                    --j;
                } else {
                    break;
                }
            }
            arr[j + 1] = temp;
        }
    }

    public static boolean checkIP(String ip) {
        String regex = "[0-225]\\.[0-225]\\.[0-225]\\.[0-225]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(ip);
        return matcher.matches();
    }


    public static int reverseNumb(int num) {
        if (num >= -9 && num <= 9) {
            return num;
        }
        long res = 0;
        while (num != 0) {
            res *= 10;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                return 0;
            }
            res += num % 10;
            num /= 10;
        }
        return (int) res;
    }

    public static int strToInt(String str) {
        int len = str.length() - 1;
        int count = 1;
        int res = 0;
        while (len >= 0) {
            char tmp = str.charAt(len);
            int n = tmp - '0';
            res += n * count;
            count *= 10;
            len--;
        }
        return res;
    }

    //最长公共前缀
    public static String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs.length == 0) {
            return res;
        }
        StringBuilder sb = new StringBuilder();
        String matcher = strs[0];
        for (char tmp : matcher.toCharArray()) {
            sb.append(tmp);
            for (String str : strs) {
                if (!str.startsWith(sb.toString())) {
                    return res;
                }
            }
            res = sb.toString();
        }
        return res;
    }

    //移除指定元素
    public static int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (val == nums[i]) {
                for (int j = i; j < len - 1; ++j) {
                    nums[j] = nums[j+1];
                }
                len--;
                i--;
            }
        }
        return len;
    }

    //判断字符串包含
    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.equals("")) {
            return 0;
        }
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needle.length() - 1 > haystack.length() - 1) {
                    return -1;
                }
                int start1 = i;
                int start2 = 0;
                int end1 = start1 + needle.length() - 1;
                while (start1 <= end1 && start2 <= needle.length()) {
                    if (haystack.charAt(start1) == needle.charAt(start2)) {
                        ++start1;
                        ++start2;
                    } else {
                        break;
                    }
                }
                if (start2 == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }

    //移除重复元素
    public static int removeDuplicates(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int len = nums.length;
        for (int i = 0; i < len; ++i) {
            if (set.contains(nums[i])) {
                for (int j = i; j < len - 1; ++j) {
                    nums[j] = nums[j+1];
                }
                len--;
                i--;
            } else {
                set.add(nums[i]);
            }
        }
        return len;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode res = null;
        if (l1.val > l2.val) {
            res = new ListNode(l2.val);
            l2 = l2.next;
        } else {
            res = new ListNode(l1.val);
            l1 = l1.next;
        }
        ListNode listNode = res;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            if (val1 > val2) {
                listNode.next = new ListNode(val2);
                l2 = l2.next;
            } else {
                listNode.next = new ListNode(val1);
                l1 = l1.next;
            }
            listNode = listNode.next;
        }
        if (l1 != null) {
            listNode.next = l1;
        }
        if (l2 != null) {
            listNode.next = l2;
        }
        return res;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (target <= nums[i]) {
                return i;
            }
            ++i;
        }
        return nums.length;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("/Users/liuchenhui/workspace/algorithm/algorithm/src/com/test/niko/in.txt");
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024 * 1024];
            int res = 0;
            int i = 0;
            while ((res = fileInputStream.read(bytes)) != -1) {
                String fileName = "/Users/liuchenhui/workspace/algorithm/algorithm/src/com/test/niko/in_" + i + ".txt";
                File spFile = new File(fileName);
                fileOutputStream = new FileOutputStream(spFile);
                fileOutputStream.write(bytes);
                fileOutputStream.flush();
                ++i;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fileInputStream.close();
            fileOutputStream.close();
        }
    }

    public static int[] quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return arr;
        }
        int index = computePosition(arr, start, end);
        quickSort(arr, 0, index -1);
        quickSort(arr, index + 1, end);
        return arr;
    }

    public static int computePosition(int arr[], int start, int end) {
        int temp = arr[start];
        while (start < end) {
            while (start < end && arr[end] > temp) {
                end--;
            }

            if (start < end) {
                arr[start] = arr[end];
                start++;
            }

            while (start < end && arr[start] < temp) {
                start++;
            }

            if (start < end) {
                arr[end] = arr[start];
                end--;
            }
        }
        arr[start] = temp;
        return start;
    }
}
