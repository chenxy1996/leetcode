package 题目._80_有非常巧妙的解法_删除排序数组中的重复项2.更棒的解法;

public class Solution {
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0,0,0,1,1,1,2,3,4,5,5,5};
        System.out.println(removeDuplicates(nums));
    }
}
