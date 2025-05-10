package array.easy;

import util.IBaseClass;
//leetCode 1752
public class CheckIfArrayIsSortedAndRotated implements IBaseClass {
    public static final int[] nums = {3,4,5,1,2};

    public static void main(String[] args) {
        var cls = new CheckIfArrayIsSortedAndRotated();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int bp = 0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[i-1]) bp++;
        }
        if(nums[0]<nums[nums.length-1])bp++;
        System.out.println(bp<=1);
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
