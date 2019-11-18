package com.test.niko;

/**
 * Created by nikoliu on 2019/11/18.
 */
public class LinkList <T> {
    T value;
    LinkList<T> next;

    public LinkList(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public LinkList<T> getNext() {
        return next;
    }

    public void setNext(LinkList<T> next) {
        this.next = next;
    }

    public LinkList reserver() {
        LinkList head = this;
        LinkList pre = null;
        while (head != null) {
            LinkList current = head;
            current.next = pre;
            pre = current;
            head = head.next;
        }
        return pre;
    }

    public void addNode(LinkList linkList) {
        LinkList head = this;
        while (head.next != null) {
            head = head.next;
        }
        head.next = linkList;
    }
}
