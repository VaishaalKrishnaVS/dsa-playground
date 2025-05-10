package array.easy;

import util.IBaseClass;

import java.util.Arrays;
//leetCode 3131
public class FindTheIntegerAddedToArrayI  implements IBaseClass {
    public static final int[] nums1 = {2,6,4}, nums2 = {9,7,5};

    public static void main(String[] args) {
        var cls = new FindTheIntegerAddedToArrayI();
        cls.better();
    }
    @Override
    public void bruteForce() {
        int v = Arrays.stream(nums2).min().getAsInt() - Arrays.stream(nums1).min().getAsInt();
        System.out.println(v);
    }

    @Override
    public void better() {
        int m1 = Integer.MAX_VALUE;
        int m2 = Integer.MAX_VALUE;
        for(int i=0;i<nums1.length;i++){
            m1 = Math.min(m1, nums1[i]);
            m2 = Math.min(m2, nums2[i]);
        }
        System.out.println(m2-m1);

    }

    @Override
    public void optimal() {

    }
}
