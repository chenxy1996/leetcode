package 题目._1401_圆和矩形是否有重叠;

public class Solution {
    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        double x= 0.5*(x1+x2),y=0.5*(y1+y2);
        double lenx = x2-x1,leny = y2-y1;
        double disx = Math.abs(x_center-x);
        double disy = Math.abs(y_center-y);
        double dis = Math.max(disx-lenx/2,0.0)*Math.max(disx-lenx/2,0.0)+Math.max(disy-leny/2,0.0)*Math.max(disy-leny/2,0.0);
        return dis<=radius*radius;
    }
}
