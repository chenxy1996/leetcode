package 滑动窗口和字符串._0992_困难_难以理解_K个不同数的子数组.另一个思路;

import java.util.HashMap;

/**
 *
 * 还有一个思路是：
 * 要计算（正好包含K个不同整数的子数组的）数量，可以计算（包含少于或等于K个不同整数的子数组的）
 * 数量，减去（包含少于或等于K-1个不同整数的子数组的）数量，来获得。
 *至于具体如何计算（包含少于或等于K个不同整数的子数组的）数量，
 * 即numberOfNotMoreThan(int K)的逻辑如下：
 * 可以初始化low=count=numberOfDistinct=hash[1,n]=0, high=-1，其中
 * numberOfDistinct表示[low, high]窗口内不同整数的个数。
 * 每次循环依次执行下述操作（直到high到达最后一个元素）：
 *
 * 将[low,high]窗口右边的第一个元素v[high+1]加入到窗口中（表现为更新hash表和numberOfDistinct）
 * 保持numberOfDistinct<=K（通过右移low并更新hash表来实现）
 * 计算（[low, high]窗口内以high对应元素作为最后一个元素的）子数组的数量
 *
 */
public class Solution {
    public static int subarraysWithKDistinct(int[] A, int K) {
        if (A == null) {
            return 0;
        }
        return numberOfNotMoreThan(A, K) - numberOfNotMoreThan(A,K - 1);
    }

    private static int numberOfNotMoreThan(int[] nums, int n) {
        int l = 0;
        int r = 0;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() > n) {
                int leftVal = nums[l];
                if (map.get(leftVal) == 1) {
                    map.remove(leftVal);
                } else {
                    map.put(leftVal, map.get(leftVal) - 1);
                }
                l++;
            }
            r++;
            ans += r - l;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,1,1,1,2};
        System.out.println(subarraysWithKDistinct(nums, 1));
//        System.out.println(numberOfNotMoreThan(nums, 2));
    }
}
