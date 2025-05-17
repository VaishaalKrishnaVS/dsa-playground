package array.medium;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.Arrays;
//leetCode 1685
public class SumOfAbsoluteDifferenceInASortedArray implements IIntutuionClass, IOptimalClass {
    public static final int[] nums = {1,4,6,8,10};

    public static void main(String[] args) {
        var cls = new SumOfAbsoluteDifferenceInASortedArray();
        cls.optimal();
    }
    // 53/59 testcases passed
    @Override
    public void bruteForce() {
        int[] ans = new int[nums.length];
        int c=0;
        for(int i: nums){
            int sum = 0;
            for(int j:nums){
                sum+= Math.abs(i-j);
            }
            ans[c++]=sum;
        }
        System.out.println(Arrays.toString(ans));
    }

    @Override
    public void optimal() {
        var ts =0;
        for(int i:nums) ts+=i;
        var ls =0;
        int n = nums.length;
        var ans = new int[n];
        for(int i = 0; i< n; i++){
            var lv = (nums[i]*i) - ls;
            var rv = ts-ls - nums[i]*(n-i);
            ls+=nums[i];
            ans[i] = lv+rv;
        }
        System.out.println(Arrays.toString(ans));
    }
}
