package com.test.niko;

import java.util.HashMap;

/**
 * Created by nikoliu on 2019/12/23.
 */
public class LRUCache {
    HashMap<String, Node> hashMap;
    Node head;
    Node end;
    int limit;

    public class Node {
        String key;
        String value;
        Node pre;
        Node next;

        public Node(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public LRUCache init(int size) {
        limit = size;
        hashMap = new HashMap<>();
        return this;
    }

    public void put(String key, String value) {
        Node node = hashMap.get(key);
        if (node == null) {
            if (hashMap.size() == limit) {
                String old = remove(head);
                hashMap.remove(old);
            }
            node = new Node(key, value);
            add(node);
            hashMap.put(key, node);
        } else {
            node.value = value;
            fresh(node);
        }
    }

    public String getCache(String key) {
        Node node = hashMap.get(key);
        if (node == null) {
            return null;
        }
        fresh(node);
        return node.value;
    }

    public void fresh(Node node) {
        if (node == end) {
            return;
        }
        remove(node);
        add(node);
    }

    public void add(Node node) {
        if (end != null) {
            end.next = node;
            node.pre = end;
        }
        end = node;
        if (head == null) {
            head = node;
        }
    }

    public String remove(Node node) {
        if (node == end) {
            end = end.pre;
        }
        else if (node == head) {
            head = head.next;
        } else {
            node.pre.next = node.next;
            node.next.pre = node.pre;
        }
        return node.key;
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache().init(5);
        lruCache.put("1", "a");
        lruCache.put("2", "b");
        lruCache.put("3", "c");
        lruCache.put("4", "d");
        lruCache.put("5", "e");
        lruCache.put("6", "xxx");
        System.out.println(lruCache);
    }
}
