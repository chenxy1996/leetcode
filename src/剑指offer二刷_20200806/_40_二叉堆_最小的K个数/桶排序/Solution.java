package 剑指offer二刷_20200806._40_二叉堆_最小的K个数;

public class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        // 桶排序
        int[] map = new int[10001];
        for(int i = 0; i < arr.length; i++) {
            map[arr[i]]++;
        }
        int[] ans = new int[k];
        int p = 0;
        for(int i = 0; p < k && i < map.length; i++) {
            for(int j = 0; j < map[i] && p < k; j++) {
                ans[p++] = i;
            }
        }
        return ans;
    }
}
