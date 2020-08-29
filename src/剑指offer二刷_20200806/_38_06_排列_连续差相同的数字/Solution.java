package 剑指offer二刷_20200806._38_06_排列_连续差相同的数字;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] numsSameConsecDiff(int N, int K) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i <= 9; i++) {
            generate(i, N, K, 1, ans);
        }
        int[] res = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    private void generate(int num, int N, int K, int p, List<Integer> ans) {
        if (p == N) {
            ans.add(num);
            return;
        }
        if (num == 0) {
            return;
        }
        int lastNumber = num % 10;
        if (lastNumber >= K) {
            generate(num * 10 + (lastNumber - K), N, K, p + 1, ans);
        }
        if (lastNumber + K <= 9 && lastNumber + K != lastNumber - K) {
            generate(num * 10 + (lastNumber + K), N, K, p + 1, ans);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.numsSameConsecDiff(2, 0);
        System.out.println(Arrays.toString(ints));
    }
}
