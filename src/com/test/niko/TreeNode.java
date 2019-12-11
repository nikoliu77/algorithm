package com.test.niko;


import java.util.List;
import java.util.Stack;

/**
 * Created by nikoliu on 2019/11/21.
 */
public class TreeNode <T>{
    String value;
    TreeNode left;
    TreeNode right;

    public TreeNode(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode() {
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public void addNode(TreeNode treeNode, String a, String b) {
        treeNode.setLeft(new TreeNode(a));
        treeNode.setRight(new TreeNode(b));
    }

    public void preScan(List<String> res, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        res.add(treeNode.getValue());
        preScan(res, treeNode.getLeft());
        preScan(res, treeNode.getRight());
    }

    public void preScanV1(List<String> res, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (treeNode != null) {
            TreeNode tmp = stack.pop();
            res.add(tmp.getValue());
            stack.push(treeNode.getRight());
            treeNode = treeNode.getLeft();
            while (!stack.isEmpty()) {
                tmp = stack.pop();
                res.add(tmp.getValue());
            }
        }
    }

    public void minScan(List<String> res, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        minScan(res, treeNode.getLeft());
        res.add(treeNode.getValue());
        minScan(res, treeNode.getRight());
    }

    public void afScan(List<String> res, TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        afScan(res, treeNode.getLeft());
        afScan(res, treeNode.getRight());
        res.add(treeNode.getValue());
    }

    public void preSearch(StringBuilder sb, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(treeNode);
        while (!stack.isEmpty()) {
            TreeNode tmp = stack.pop();
            sb.append(tmp.getValue());
            if (tmp != null) {
                if (tmp.getRight() != null)
                stack.push(tmp.getRight());
                if (tmp.getLeft() != null)
                stack.push(tmp.getLeft());
            }
        }
    }

    public void minSearch(StringBuilder sb, TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() && treeNode != null) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }  else {
                treeNode = stack.pop();
                sb.append(treeNode.getValue());
                treeNode = treeNode.getRight();
            }

        }
    }

}
