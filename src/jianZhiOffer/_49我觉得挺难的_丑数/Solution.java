package jianZhiOffer._49我觉得挺难的_丑数;

/**
 * 这里第一次做没有做出来，直接看别人的解答
 */

public class Solution {
    public int nthUglyNumber(int n) {
        int a = 0; // * 2
        int b = 0; // * 3
        int c = 0; // * 5
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 1; i < n; i++) {
            int aa = res[a] * 2;
            int bb = res[b] * 3;
            int cc = res[c] * 5;
            int min = Math.min(aa, Math.min(bb, cc));
            if (min == aa) {
                a++;
            }
            if (min == bb) {
                b++;
            }
            if (min == cc) {
                c++;
            }
            res[i] = min;
        }
        return res[n - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.nthUglyNumber(10));
    }
}
