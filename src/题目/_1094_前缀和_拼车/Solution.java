package 题目._1094_前缀和_拼车;

public class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] record = new int[1001];
        for (int[] trip : trips) {
            record[trip[1]] += trip[0];
            record[trip[2]] -= trip[0];
        }
        int sum = 0;
        for (int i : record) {
            sum += i;
            if (sum > capacity) {
                return false;
            }
        }
        return true;
    }
}
