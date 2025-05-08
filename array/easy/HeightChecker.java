package array.easy;

import util.IBaseClass;

import java.util.Arrays;
//leetCode 1051
public class HeightChecker implements IBaseClass {
    private static final int[] heights = {1,2,2,3,5,7,4,10};

    public static void main(String[] args) {
        var cls = new HeightChecker();
        cls.better();
    }
    @Override
    public void bruteForce() {
        int ans = 0;
        int[] sh = heights.clone();
        Arrays.sort(sh);
        System.out.println(Arrays.toString(sh));
        System.out.println(Arrays.toString(heights));
        for(int i=0;i<sh.length;i++){
            if(sh[i]!=heights[i])ans++;
        }
        System.out.println(ans);
    }

    @Override
    public void better() {
        int[] cs = new int[101];
        for(int i: heights) cs[i]++;
        int c=0;
        int ans=0;
        for(int i=0;i<101;i++){
            int v= cs[i];
            if(v==0) continue;
            while (v-->0) {
                if(heights[c++] != i) ans++;
            }
        }
        System.out.println(ans);

    }

    @Override
    public void optimal() {

    }
}
