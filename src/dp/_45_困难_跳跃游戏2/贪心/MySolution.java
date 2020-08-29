package dp._45_困难_跳跃游戏2.贪心;

public class MySolution {
    public static int jump(int[] nums) {
        int count = 0;
        int far = 0;
        int end = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                count++;
                end = far;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums));
    }
}
