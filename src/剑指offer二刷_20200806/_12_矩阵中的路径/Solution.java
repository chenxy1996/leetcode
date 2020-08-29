package 剑指offer二刷_20200806._12_矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, chars, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean search(char[][] board, int x, int y, char[] word, int p) {
        if (p == word.length) {
            return true;
        }
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return false;
        }
        char c = board[x][y];
        if (c == 0 || c != word[p]) {
            return false;
        }
        board[x][y] = 0;
        boolean res = false;
        res = search(board, x - 1, y, word, p + 1) ||
                search(board, x + 1, y, word, p + 1) ||
                search(board, x, y - 1, word, p + 1) ||
                search(board, x, y + 1, word, p + 1);
        if (res) {
            return true;
        }
        board[x][y] = word[p];
        return false;
    }
}
