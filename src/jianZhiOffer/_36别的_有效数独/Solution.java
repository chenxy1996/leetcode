<<<<<<< HEAD
package jianZhiOffer._36别的_有效数独;

public class Solution {
    // 利用位运算来判断某个数字是否重复
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // 行
        for (int i = 0; i < 9; i++) {
            // 列
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int pos = c - '0';
                    int boxNth = (i / 3) * 3 + (j / 3);

                    if (!(isOne(rows, i, pos) && isOne(cols, j, pos) && isOne(boxes, boxNth, pos))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 判断数组里面某个二进制 number 某位是否为 0, 为 0 则返回 true
    // 并把该 number 上该位设置为 1
    private static boolean isOne(int[] numbers, int nth, int pos) {
        int target = numbers[nth];
        boolean res = false;
        if (((target >> pos) & 1) == 0) {
            res = true;
            numbers[nth] |= 1 << pos;
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] board =
                {       {'8','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };

        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
=======
package jianZhiOffer._36别的_有效数独;

public class Solution {
    // 利用位运算来判断某个数字是否重复
    public boolean isValidSudoku(char[][] board) {
        int[] rows = new int[9];
        int[] cols = new int[9];
        int[] boxes = new int[9];

        // 行
        for (int i = 0; i < 9; i++) {
            // 列
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    int pos = c - '0';
                    int boxNth = (i / 3) * 3 + (j / 3);

                    if (!(isOne(rows, i, pos) && isOne(cols, j, pos) && isOne(boxes, boxNth, pos))) {
                        return false;
                    }
                }
            }
        }

        return true;
    }

    // 判断数组里面某个二进制 number 某位是否为 0, 为 0 则返回 true
    // 并把该 number 上该位设置为 1
    private static boolean isOne(int[] numbers, int nth, int pos) {
        int target = numbers[nth];
        boolean res = false;
        if (((target >> pos) & 1) == 0) {
            res = true;
            numbers[nth] |= 1 << pos;
        }

        return res;
    }

    public static void main(String[] args) {
        char[][] board =
                {       {'8','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                };

        Solution s = new Solution();
        System.out.println(s.isValidSudoku(board));
    }
}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
