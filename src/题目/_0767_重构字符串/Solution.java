package 题目._0767_重构字符串;

import java.util.PriorityQueue;

public class Solution {
    private static class Node {
        char c;
        int cnt;

        Node(char c) {
            this.cnt = 1;
            this.c = c;
        }
    }

    public static String reorganizeString(String S) {
        if (S == null || S.length() == 0) {
            return "";
        }
        Node[] map = new Node[26];
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (map[c - 'a'] != null) {
                map[c - 'a'].cnt++;
            } else {
                map[c - 'a'] = new Node(c);
            }
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.cnt - a.cnt);
        for(Node node : map) {
            if (node != null) {
                queue.add(node);
            }
        }
        if (queue.peek().cnt > (S.length() + 1) / 2) {
            return "";
        }
        int p = 0;
        char[] cs = new char[S.length()];
        while (queue.size() >= 2) {
            Node first = queue.poll();
            Node second = queue.poll();
            if (p == 0 || cs[p - 1] != first.c) {
                cs[p++] = first.c;
                cs[p++] = second.c;
            } else {
                cs[p++] = second.c;
                cs[p++] = first.c;
            }
            if (--first.cnt > 0) {
                queue.add(first);
            }
            if (--second.cnt > 0) {
                queue.add(second);
            }
        }
        if (!queue.isEmpty()) {
            cs[p] = queue.poll().c;
        }
        return String.valueOf(cs);
    }

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(reorganizeString(s));
    }
}
