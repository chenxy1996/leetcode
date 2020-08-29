package 难点_二分法.LCP_12_小张刷题计划_分割数组的最大值变种;

/**
 * 给定一个数组，将其划分成 M 份，使得每份元素之和最大值最小，每份可以任意减去其中一个元素。
 */
public class Solution {
    public int minTime(int[] time, int m) {
        int right = 0;
        int left = 0;
        int n = time.length;

        for(int i=0;i<n;i++){
            right += time[i];
        }
        int mid = 0;
        while(left <= right){
            mid = (left + right)/2;

            int useday = 1;
            //此时判断分配的"数组区间的最大时间" mid 能否满足需求
            int totaltime = 0;   //区间所花的时间
            int maxtime = time[0];   //当前区间的最大值  初始化为数组起始值

            for(int i=1;i<n;i++){
                int nexttime =  Math.min(maxtime,time[i]);   //判断下个题目的时间
                if(totaltime + nexttime <= mid){
                    totaltime += nexttime;
                    maxtime = Math.max(maxtime,time[i]);
                }else{
                    //此时上个区间时间已布满  开始判断下个区间
                    useday++;
                    totaltime = 0;
                    maxtime = time[i];
                }
            }
            if(useday <= m){
                //分配的天数 多于 实际花费的天数 。 说明每天的最长时间可以减小
                right = mid - 1;
            }else{
                left = mid + 1;
            }

        }
        //结束时 left的值即为每天所花的最长时间中最小的那个
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int m = 2;
        System.out.println(new Solution().minTime(nums, m));
    }
}
