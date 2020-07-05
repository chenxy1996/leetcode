<<<<<<< HEAD
package jianZhiOffer._13hard_movingCount;

public class Solution {
    public int movingCount(int m, int n, int k) {
        char[][] chars = new char[m][n];
        return move(0, 0, m, n, k, chars);
    }

    private int move(int i, int j, int m, int n, int k, char[][] chars) {
        if (i <= m - 1 && j <= n - 1 && sum(i, j) <= k && chars[i][j] != '*') {
            chars[i][j] = '*';
            return 1 + move(i + 1, j, m, n, k, chars) + move(i, j + 1, m, n, k, chars);
        } else {
            return 0;
        }
    }

    private static int sum(int k, int j) {
        int sum = 0;
        int rem;

        while (k != 0) {
            rem = k % 10;
            k = k / 10;
            sum += rem;
        }

        while (j != 0) {
            rem = j % 10;
            j = j / 10;
            sum += rem;
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(sum(23, 23));
        Solution s = new Solution();
        System.out.println(s.movingCount(3, 1, 0));
    }

}
=======
package jianZhiOffer._13hard_movingCount;

public class Solution {
    public int movingCount(int m, int n, int k) {
        char[][] chars = new char[m][n];
        return move(0, 0, m, n, k, chars);
    }

    private int move(int i, int j, int m, int n, int k, char[][] chars) {
        if (i <= m - 1 && j <= n - 1 && sum(i, j) <= k && chars[i][j] != '*') {
            chars[i][j] = '*';
            return 1 + move(i + 1, j, m, n, k, chars) + move(i, j + 1, m, n, k, chars);
        } else {
            return 0;
        }
    }

    private static int sum(int k, int j) {
        int sum = 0;
        int rem;

        while (k != 0) {
            rem = k % 10;
            k = k / 10;
            sum += rem;
        }

        while (j != 0) {
            rem = j % 10;
            j = j / 10;
            sum += rem;
        }

        return sum;
    }

    public static void main(String[] args) {
//        System.out.println(sum(23, 23));
        Solution s = new Solution();
        System.out.println(s.movingCount(3, 1, 0));
    }

}
>>>>>>> 646cbc9e7d1df523ebf453f3c08d135fb5b4ec35
