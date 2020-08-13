package 前缀和._10_前缀和_我觉得挺难的_生存人数;

/**
 * 和 1094 题类似
 */
public class Solution {
    public static int maxAliveYear(int[] birth, int[] death) {
        int[] counter = new int[102];
        for(int i = 0; i < birth.length
                ; i++) {
            counter[birth[i] - 1900]++;
            counter[death[i] - 1900 + 1]--;
        }
        int sum = 0;
        int max = 0;
        int ans = 0;
        for (int i = 0; i < counter.length; i++) {
            sum += counter[i];
            if (sum > max) {
                ans = i;
                max = sum;
            }
        }
        return ans + 1900;
    }

    public static void main(String[] args) {
        int[] birth = {1972,1908,1915,1957,1960,1948,1912,1903,1949,1977,1900,1957,1934,1929,1913,1902,1903,1901};
        int[] death = {1997,1932,1963,1997,1983,2000,1926,1962,1955,1997,1998,1989,1992,1975,1940,1903,1983,1969};
        System.out.println(maxAliveYear(birth, death));
    }
}
