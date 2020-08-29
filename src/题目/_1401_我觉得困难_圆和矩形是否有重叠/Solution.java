package 题目._1401_我觉得困难_圆和矩形是否有重叠;

/**
 * 详细可见 https://leetcode-cn.com/problems/circle-and-rectangle-overlapping/solution/yan-zheng-ju-xing-qu-yu-nei-de-dian-dao-yuan-xin-z/
 */

/**
 * 先计算矩形中心，边长；
 * 把矩形中心，圆心投影到坐标轴上；
 * 计算矩形中心与圆心在坐标轴上的距离；
 * 判断，圆心超出矩形的距离是否小于等于圆的半径;
 */
public class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double x= 0.5*(x1+x2),y=0.5*(y1+y2);
        double lenx = x2-x1,leny = y2-y1;
        double disx = Math.abs(x_center-x);
        double disy = Math.abs(y_center-y);
        // 下面这个 Math.max(disx - lenx/2,0.0) 是有正方形包含圆形的情况
        double dis = Math.max(disx-lenx/2,0.0)*Math.max(disx-lenx/2,0.0)+Math.max(disy-leny/2,0.0)*Math.max(disy-leny/2,0.0);
        return dis<=radius*radius;
    }
}
