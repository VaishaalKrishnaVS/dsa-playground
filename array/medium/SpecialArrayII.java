package array.medium;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.Arrays;
//leetCode 3152
public class SpecialArrayII implements IIntutuionClass, IOptimalClass {
    public static final int[] nums = {4,3,1,6};
    public static final int[][] queries = {{0,2},{2,3}};

    public static void main(String[] args) {
        var cls =  new SpecialArrayII();
        cls.optimal();
    }
    // 535/536test cases  passed
    @Override
    public void bruteForce() {
        var map = new boolean[nums.length];
        for(int i=1;i<nums.length;i++){
            map[i] = isParity(nums[i-1], nums[i]);
        }
        var ans = new boolean[queries.length];
        int c=0;
        for(var ar:queries){
            var isPar = true;
            for(int i=ar[0]+1;i<=ar[1];i++){
                isPar = isPar && map[i];
                if(!isPar) break;
            }
            ans[c++] = isPar;
        }
        System.out.println(Arrays.toString(ans));
    }
    public static boolean isParity(int p, int c){
        return (p + c) % 2 != 0;
    }

    @Override
    public void optimal() {
        var msp = new int[nums.length];
        for(int i=1;i< nums.length;i++){
           msp[i] = msp[i-1]+ (isParity(nums[i-1], nums[i])?0:1);
        }
        var ans = new boolean[queries.length];
        int c=0;
        for(var q:queries){
            ans[c++] = (msp[q[1]]-msp[q[0]]) <1;
        }
        System.out.println(Arrays.toString(ans));

    }
}
