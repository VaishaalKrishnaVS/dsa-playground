package array.easy;

import util.IBaseClass;
//leetCode 3028
public class AntOnTheBoundary implements IBaseClass {
    public static final int[] nums = {3,2,-3,-4};

    public static void main(String[] args) {
        var cls = new AntOnTheBoundary();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int ans = 0;
        int cp = 0;
        for(int i: nums){
            cp+=i;
            if(cp==0) ans++;
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
