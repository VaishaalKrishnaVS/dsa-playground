package neetcode.twopointer;

import util.IBaseClassV2;

import java.util.Arrays;

public class TrappingRainWater implements IBaseClassV2<Integer, int[]> {
    public static void main(String[] args) {
        var cls = new TrappingRainWater();
        System.out.println(cls.optimal(new int[]{4,2,0,3,2,5}));
    }
    @Override
    public Integer intution(int[] heights) {
        int[] pm = new int[heights.length];
        int[] sm = new int[heights.length];
        pm[0] = heights[0];
        sm[sm.length-1] = heights[heights.length-1];
        for(int i=1;i< sm.length;i++) pm[i] = Math.max(pm[i-1], heights[i]);
        for(int i= sm.length-2;i>= 0;i--) sm[i] = Math.max(sm[i+1], heights[i]);
        System.out.println(Arrays.toString(pm));
        System.out.println(Arrays.toString(sm));
        System.out.println(Arrays.toString(heights));
        int ans = 0;
        for(int i=0;i<heights.length;i++){
            int h = Math.min(pm[i], sm[i]) - heights[i];
            ans += Math.max(h, 0);
        }
        return ans;
    }

    @Override
    public Integer optimal(int[] heights) {
        int l=0,r= heights.length-1, lmax=heights[0], rmax=heights[heights.length-1];
        int ans =0;
        while(l<r){
            if(lmax<rmax){
                l++;
                lmax = Math.max(lmax,heights[l]);
                ans += lmax-heights[l];
            }
            else {
                r--;
                rmax = Math.max(rmax, heights[r]);
                ans+= rmax-heights[r];
            }
        }
        return ans;
    }
}
