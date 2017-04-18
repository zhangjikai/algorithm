package com.zhangjikai.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jikai Zhang on 2017/4/7.
 */
public class LRUCache {

    private int capacity;

    static class Node {
        Node next;
        Node prev;

        int key;
        int value;

        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node head;
    private Node last;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        last = new Node();
        map = new HashMap<>();
        head.next = last;
        last.prev = head;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            value = map.get(key).value;
            updateNode(key);
        }
        return value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            updateNode(key);
            return;
        }
        if(map.size() == capacity) {
            map.remove(last.prev.key);
            deleteNode(last.prev);
        }
        Node node = new Node(key, value);
        addNode(node);
        map.put(key, node);
    }

    private void deleteNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }


    private void updateNode(int key) {
        Node node = map.get(key);
        deleteNode(node);
        addNode(node);
    }
}
