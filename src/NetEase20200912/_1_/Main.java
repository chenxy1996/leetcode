package NetEase20200912._1_;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static class Node {
        Node left;
        Node right;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * 10 9
     * 1 left 2
     * 1 right 3
     * 2 left 4
     * 2 right 5
     * 3 right 6
     * 6 left 7
     * 6 right 8
     * 7 left 9
     * 7 right 10
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        Map<Integer, Node> map = new HashMap<>();
        Node root = null;
        for(int i = 0; i < n; i++) {
            int id = scanner.nextInt();
            String ptr = scanner.next();
            int child = scanner.nextInt();

            Node node;
            if (map.containsKey(id)) {
                node = map.get(id);
            } else {
                node = new Node(id);
                map.put(id, node);
            }
            if (root == null) {
                root = node;
            }

            Node c = new Node(child);
            map.put(child, c);
            if (ptr.equals("left")) {
                node.left = c;
            } else {
                node.right = c;
            }
        }

        traverse(root);
        System.out.println(ans);
    }

    private static int ans = 0;

    private static int traverse(Node node) {
        if (node == null) {
            return 0;
        }
        int left = traverse(node.left);
        int right = traverse(node.right);
        if (left == 1 && right == 1) {
            ans++;
        }
        return Math.max(left, right) + 1;
    }
}
