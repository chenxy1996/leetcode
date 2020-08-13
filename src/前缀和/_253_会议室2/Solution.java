package 前缀和._253_会议室2;

public class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] counter = new int[24];
        for (int[] interval : intervals) {
            counter[interval[0]]++;
            counter[interval[1]]--;
        }
        int max = 0;
        int sum = 0;
        for (int i : counter) {
            sum += i;
            max = Math.max(sum, sum);
        }
        return max;
    }
}
