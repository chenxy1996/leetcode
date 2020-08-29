package 设计._146_LRU缓存;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCache {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int CAPACITY;
    private Node dummyHead = new Node();
    private Node tail = dummyHead;
    private Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.CAPACITY = capacity;
        if (CAPACITY != 0) {
            map = new HashMap<>();
        }
    }

    public int get(int key) {
        if (CAPACITY == 0) {
            return -1;
        }
        if (map.containsKey(key)) {
            Node p = map.get(key);
            if (p != tail) {
                remove(p);
                addTail(p);
            }
            return p.val;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (CAPACITY == 0) {
            return;
        }
        Node node;
        if (map.containsKey(key)) {
            node = map.get(key);
            node.val = value;
            if (node != tail) {
                remove(node);
                addTail(node);
            }
        } else {
            node = new Node(key, value);
            addTail(node);
            map.put(key, node);
            if (map.size() > CAPACITY) { // 删除原本的第一个节点
                map.remove(dummyHead.next.key);
                Node n = dummyHead.next.next;
                if (n != null) {
                    n.prev = dummyHead;
                    dummyHead.next = n;
                }
            }
        }
    }

    private void addTail(Node node) {
        if (tail != null) {
            tail.next = node;
            node.prev = tail;
            node.next = null;
        }
        tail = node;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        prev.next = node.next;
        if (prev.next != null) {
            prev.next.prev = prev;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
        cache.put(2, 1);
        cache.put(2, 2);
        System.out.println(cache.get(2));
        cache.put(1, 3);
        cache.put(4, 1);
        System.out.println(cache.get(2));
    }
}
