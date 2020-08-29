package 题目._1405_贪心_我觉得挺难的_最长快乐字符串;

public class OptimalSolution {
    public static String longestDiverseString(int a, int b, int c) {
        int[] nums = new int[]{a,b,c};
        StringBuilder sb = new StringBuilder();
        //last访问下标
        int last = -1;
        //重复last则noVis下标不能再访问了
        int noVis = -1;
        while (true){
            int max = 0 ;
            int index = -1;
            for (int i = 0; i < 3; i++) {
                //不访问noVis下标
                if(i!=noVis && nums[i] > max){
                    max = nums[i];
                    index = i;
                }
            }
            if(index == -1){
                break;
            }
            nums[index]--;
            if(last == index){
                //重复两次无法继续访问
                noVis = last;
            }else {
                //不是重复的清除无法访问标记
                noVis = -1;
            }
            last = index;
            sb.append((char)('a'+index));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(longestDiverseString(0,8,11));
    }
}
