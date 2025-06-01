package neetcode.twopointer;

import util.IBaseClassV2;

public class ContainerWithMostWater implements IBaseClassV2<Integer, int[]> {
    public static void main(String[] args) {
        var cls = new ContainerWithMostWater();
        System.out.println(cls.intution(new int[]{1,8,6,2,5,4,8,3,7}));
    }
    @Override
    public Integer intution(int[] height) {
        int s=0,e=height.length-1;
        int ans = Integer.MIN_VALUE;
        while (s<e){
            int base = e-s;
            ans = Math.max(ans, base*(Math.min(height[s],height[e])));
            if(height[s]<height[e])s++;
            else e--;
        }
        return ans;
    }
}
