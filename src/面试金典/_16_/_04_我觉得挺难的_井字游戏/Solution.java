package 面试金典._16_._04_我觉得挺难的_井字游戏;

public class Solution {
    public static String tictactoe(String[] board) {
        boolean unfilled = false;
        int n = board.length;
        int[] col = new int[n]; // 记录每一列的和
        int diagonal0 = 0;
        int diagonal1 = 0;
        for (int i = 0; i < n; i++) {
            int row = 0;
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c != ' ') {
                    // 对角线
                    if (i == j) {
                        diagonal0 += c;
                    }
                    if (i + j == n - 1) {
                        diagonal1 += c;
                    }
                    // 行
                    row += c;
                    //列
                    col[j] += c;
                } else {
                    unfilled = true;
                }
            }
            // 判断行
            if (row == 'X' * n) {
                return "X";
            }
            if (row == 'O' * n) {
                return "O";
            }
        }

        // 判断列
        for (int i : col) {
            if (i == 'X' * n) {
                return "X";
            }
            if (i == 'O' * n) {
                return "O";
            }
        }

        // 判断对角线
        if (diagonal0 == 'X' * n) {
            return "X";
        }
        if (diagonal0 == 'O' * n) {
            return "O";
        }
        if (diagonal1 == 'X' * n) {
            return "X";
        }
        if (diagonal1 == 'O' * n) {
            return "O";
        }

        if (unfilled) {
            return "Pending";
        }
        return "Draw";
    }

    public static void main(String[] args) {
        String[] s = {"O X"," XO","X O"};
        System.out.println(tictactoe(s));
    }
}
