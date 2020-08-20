package 题目._5489_二分法_没见过_两球之间的磁力;

import java.util.Arrays;

public class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l = 1;
        int weak = position[0];
        int strong = position[position.length - 1];
        int r = (strong - weak) / (m - 1);
        while (l <= r)  {
            int force = (r - l) / 2 + l;
            if (check(position, force, m)) {
                l = force + 1;
            } else {
                r = force - 1;
            }
        }
        return r;
    }

    private boolean check(int[] position, int force, int m) {
        int prev = position[0];
        int i = 1;
        m--;
        while (m > 0) {
            if (i == position.length) {
                return false;
            }
            if (position[i] - prev >= force) {
                prev = position[i];
                m--;
            }
            i++;
        }
        return m == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,4,3,2,1,1000000000};
        System.out.println(solution.maxDistance(nums, 2));
    }
}
