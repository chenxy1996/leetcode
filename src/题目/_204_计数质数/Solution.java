package 题目._204_计数质数;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是最原始的算法，利用了一个性质，大于等于 5 的质数一定在 6 的倍数左右
 */
public class Solution {
    List<Integer> store = new ArrayList<>();
    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        if (n == 3) {
            return 1;
        }
        if (n == 4) {
            return 2;
        }
        int cnt = 2;
        for (int i = 5; i < n; i += 6) {
            if (isPrime(i)) {
                store.add(i);
                cnt++;
            }
            if (i + 2 < n && isPrime(i + 2)) {
                store.add(i + 2);
                cnt++;
            }
        }
//        System.out.println(store);
        return cnt;
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int n = 100;
//        System.out.println(new Solution().countPrimes(n));
        System.out.println(isPrime(25));
    }
}
