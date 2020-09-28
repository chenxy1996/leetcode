package 题目._0071_简化路径;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public static String simplify(String path) {
        if (path == null || path.length() == 0) {
            return "";
        }
        String[] strings = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(String p : strings) {
            if (p.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.removeLast();
                }
            } else if (!p.equals("") && !p.equals(".")){
                stack.addLast(p);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("/");
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst() + "/");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String string = "/home//foo/";
        System.out.println(simplify(string));
    }
}
