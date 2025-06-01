package neetcode.twopointer;

import util.IBaseClassV2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum implements IBaseClassV2<List<List<Integer>>, int[]> {
    public static void main(String[] args) {
        var cls = new ThreeSum();
        System.out.println(cls.intution(new int[]{-1,0,1,2,-1,-4}));
    }
    public List<List<Integer>> ans = new ArrayList<>();
    @Override
    public List<List<Integer>> intution(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i< nums.length;i++){
            if(nums[i]>0) break;
            if(i>0&& nums[i]==nums[i-1]) continue;
            twoSum(i+1, nums.length-1,-nums[i],nums);
        }
        return ans;
    }
    void twoSum(int s, int e, int t, int[] nums){
        while(s<e){
            int sum = nums[s] + nums[e];
            if(sum ==t){
                List<Integer>temp = new ArrayList<>();
                temp.add(-(sum));
                temp.add(nums[e]);
                temp.add(nums[s]);
                ans.add(temp);
                while(nums[e]==nums[e-1])e--;
                while(nums[s]==nums[s+1])s++;
                s++;e--;
            }
            if(sum >t)e--;
            if(sum<t) s++;
        }
    }
}
