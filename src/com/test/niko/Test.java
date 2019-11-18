package com.test.niko;

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
        while (linkList != null) {
            System.out.println(linkList.value);
            linkList = linkList.next;
        }
    }

    public static void testSort() {
        int arr[] = {2, 1, 3, 8, 5, 9, 6, 0, 7, 4, 1, 3, 2};
        arr = SortUtils.charu(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
    public static void main(String[] args) {
        testSort();
    }
}
