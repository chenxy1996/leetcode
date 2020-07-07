package jianZhiOffer._3更好的解法_findRepeatNumber;

public class OptimalSolution {
    public int findRepeatNumber(int[] nums) {
        boolean hasZero = false;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            int p = Math.abs(val);
            int valP = nums[p];
            if (valP < 0) {
                return p;
            } else if (valP > 0) {
                nums[p] = -valP;
            } else if (p == 0) {
                if (hasZero) {
                    return 0;
                } else {
                    hasZero = true;
                }
            }
        }
        return -1;
    }

    // 根据题意，nums 中肯定是存在重复的数字的
    public int findRepeatNumber1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int val = Math.abs(nums[i]);
            int valP = nums[val];
            if (valP < 0) {
                return val;
            } else{
                nums[val] = -valP;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(new OptimalSolution().findRepeatNumber1(nums));

    }
}
