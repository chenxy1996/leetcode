package 面试金典._10_数组问题._11_峰与谷;

public class OptimalSolution {
    public static void wiggleSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if ((i & 1) == 0) { // 峰
                if (nums[i] < nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            } else { // 谷
                if (nums[i] > nums[i - 1]) {
                    int temp = nums[i - 1];
                    nums[i - 1] = nums[i];
                    nums[i] = temp;
                }
            }
        }
    }
}
