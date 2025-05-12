package array.medium;

import util.IOptimalClass;
//leetCode 80
public class RemoveDuplicatesFromSortedArrayII implements IOptimalClass {
    public static final int[] nums = {1,1,1,2,2,3};

    public static void main(String[] args) {
        var cls = new RemoveDuplicatesFromSortedArrayII();
        cls.optimal();
    }

    @Override
    public void optimal() {
        int i =0;
        for(int el:nums){
            if(i==0||i==1||el!=nums[i-2]) nums[i++]=el;
        }
        System.out.println(i);
    }
}
