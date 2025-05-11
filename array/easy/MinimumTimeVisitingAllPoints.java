package array.easy;

import util.IBaseClass;
//leetCode 1266
public class MinimumTimeVisitingAllPoints implements IBaseClass {
    public static void main(String[] args) {
        var cls = new MinimumTimeVisitingAllPoints();
        cls.bruteForce();
    }
    public static final int[][] points =  {{1,1},{3,4},{-1,0}};
    @Override
    public void bruteForce() {
        int ans = 0;
        for(int i=1;i<points.length;i++){
            int[] p = points[i-1];
            int[] c = points[i];

            ans+=Math.max(Math.abs(c[0]-p[0]), Math.abs(c[1]-p[1]));
        }
        System.out.println(ans);

    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
