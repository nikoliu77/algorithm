package com.test.niko;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikoliu on 2019/12/17.
 */
public class AboutTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        List<Integer> left = preleft(root.left, new ArrayList<Integer>());
        List<Integer> right = preRight(root.right, new ArrayList<Integer>());
        if (left.size() != right.size()) {
            return false;
        }
        for (int i = 0; i < left.size(); ++i) {
            if (left.get(i) != right.get(i)) {
                return false;
            }
        }
        return true;
    }

    public static List preleft(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return list;
        }
        list.add(root.val);
        preleft(root.left, list);
        preleft(root.right, list);
        return list;
    }

    public static List preRight(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
            return list;
        }
        list.add(root.val);
        preleft(root.right, list);
        preleft(root.left, list);
        return list;
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        if (!isSameTree(p.left, q.left)) {
            return false;
        }

        if (!isSameTree(p.right, q.right)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(2);
        p.left.left = new TreeNode(3);
        p.left.right = new TreeNode(4);
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(3);
        System.out.println(isSymmetric(p));
    }
}
