package array.easy;

import util.IBaseClass;

import java.util.Arrays;
//leetCode 2460
public class ApplyOperationsToAnArray implements IBaseClass {
    public static final int[] nums = {1,2,2,1,1,0};

    public static void main(String[] args) {
        var cls = new ApplyOperationsToAnArray();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        for(int i=0;i< nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=2*nums[i];
                nums[i+1]=0;
            }
        }
        var ans = new int[nums.length];
        int c=0;
        for(int i:nums) if(i!=0) ans[c++]=i;
        System.out.println(Arrays.toString(ans));
    }


    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
