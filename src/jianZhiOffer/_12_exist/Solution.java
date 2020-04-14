package jianZhiOffer._12_exist;

import java.util.ArrayList;
import java.util.List;
import java.util.List;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // 用来记录已经走过的格子
                List<List<Integer>> stack = new ArrayList<>();
                if (next(i, j, board, word, 0, stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean next(int x, int y, char[][] board, String word, int nextCharPos, List<List<Integer>> stack) {
        // 如果 nextCharPos 大于等于 word 的长度说明已经找到了路径
        if (nextCharPos == word.length()) {
            return true;
        }

        int row = board.length;
        int col = board[0].length;

        if ((0 <= x && 0 <= y) && (x < row && y < col)) {
            List<Integer> coordinate = new ArrayList<>();
            coordinate.add(x);
            coordinate.add(y);

            // 如果当前格子之前已经走过
            if (stack.contains(coordinate)) {
                return false;
            }

            // 当前格子中的字符
            char c = board[x][y];

            // 判断当前格子中的字符和 word 中应该匹配的字符是否相同
            // 如果不同
            if (c != word.charAt(nextCharPos)) {
                return false;
            } else {
                // 如果相同
                stack.add(coordinate);
                return next(x - 1, y, board, word, nextCharPos + 1, new ArrayList<>(stack)) || // 上
                        next(x, y - 1, board, word, nextCharPos + 1, new ArrayList<>(stack)) || // 左
                        next(x, y + 1, board, word, nextCharPos + 1, new ArrayList<>(stack)) || // 右
                        next(x + 1, y, board, word, nextCharPos + 1, new ArrayList<>(stack)); // 下
            }

        } else {
            return false;
        }
    }

    public static void main(String[] args) {
//        char[][] board = new char[][] {{'a','b','c','e'}, {'s', 'f', 'e', 's'}, {'a', 'd', 'e', 'e'}};
        char c = '\u0024';
        System.out.println(c);
        System.out.println("chen");
    }
}
