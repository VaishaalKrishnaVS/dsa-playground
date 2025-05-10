package array.easy;

import util.IBaseClass;
//leetCode 1800
public class MaximumAscendingSubarraySum implements IBaseClass {
    private static final int[]nums = {10,20,30,5,10,50};

    public static void main(String[] args) {
        var cls = new MaximumAscendingSubarraySum();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int max = Integer.MIN_VALUE;
        int sum = nums[0];
        for(int i=1;i< nums.length;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
            }
            else {
                max = Math.max(sum, max);
                sum=nums[i];
            }
        }
        System.out.println(Math.max(sum, max));
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
