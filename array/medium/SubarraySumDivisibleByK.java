package array.medium;

import util.IOptimalClass;

//leetCode 974
public class SubarraySumDivisibleByK implements IOptimalClass {
    public static void main(String[] args) {
        var cls = new SubarraySumDivisibleByK();
        cls.optimal();
    }
    public static final int[] nums = {4,5,0,-2,-3,1};
    public static final int k = 5;
    @Override
    public void optimal() {
        var map = new int[k];
        var prefixSumValue = 0;
        var ans = 0;
        map[0]=1;
        for(int i=0;i<nums.length;i++){
            prefixSumValue= (prefixSumValue+nums[i]+k)%k;
            ans+=map[prefixSumValue];
            map[prefixSumValue]++;
        }
        System.out.println(ans);
    }
}
