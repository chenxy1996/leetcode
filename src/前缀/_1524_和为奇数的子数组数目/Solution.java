package 前缀和._1524_和为奇数的子数组数目;

public class Solution {
    public int numOfSubarrays(int[] arr) {
        if (arr == null) {
            return 0;
        }
        int mod = 1000000007;
        long sum = 0;
        int even = 0;
        int odd = 0;
        int ans = 0;
        for(int num : arr) {
            sum += num;
            if ((sum & 1) == 1) { // 奇
                ans = (1 + even + ans) % mod;;
                odd++;
            } else { // 偶
                ans = (ans + odd) % mod;;
                even++;
            }
        }
        return ans % mod;
    }
}
