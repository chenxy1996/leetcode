package dfs._79_单词搜索;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean res = find(board, word, 0, i, j);
                if (res) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean find(char[][] board, String word, int p, int i, int j) {
        if (p >= word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }


        if (board[i][j] == word.charAt(p) && board[i][j] != '\0') {
            char c = board[i][j];

            // 标记
            board[i][j] = '\0';
            boolean res =   find(board, word, p + 1, i - 1, j) || // 上
                            find(board, word, p + 1, i + 1, j) || // 下
                            find(board, word, p + 1, i, j - 1) || // 左
                            find(board, word, p + 1, i, j + 1);   // 右
            // 还原标记
            board[i][j] = c;

            return res;
        } else {
            return false;
        }
    }
}
