package array.easy;

import util.IBaseClass;

import java.util.Arrays;

//leetCode 977
public class SquaresOfSortedArray implements IBaseClass {
    private static final int[] nums = {-4,-1,0,3,10};

    public static void main(String[] args) {
        var cls = new SquaresOfSortedArray();
        cls.better();
    }
    @Override
    public void bruteForce() {
        int[] ans = new int[nums.length];
        for(int i=0;i< nums.length;i++){
            ans[i]= nums[i]*nums[i];
        }
        Arrays.sort(ans);
        System.out.println(Arrays.toString(ans));
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        int n = nums.length;
        int l =0;
        int r=n-1;
        int[] ans = new int[n];
        int c = n-1;
        while (l<=r){
            int lv = nums[l]*nums[l];
            int rv = nums[r]*nums[r];
            if(lv>rv){
                ans[c--]=lv;
                l++;
            }else {
                ans[c--]=rv;
                r--;
            }
        }
        System.out.println(Arrays.toString(ans));
    }
}
