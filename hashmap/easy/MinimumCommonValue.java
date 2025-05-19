package hashmap.easy;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.HashSet;
//leetCode 2540
public class MinimumCommonValue implements IIntutuionClass, IOptimalClass {
    public static final int[]nums1 ={1,2,3}, nums2 = {2,4};

    public static void main(String[] args) {
        var cls = new MinimumCommonValue();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var map = new HashSet<Integer>();
        int ans =0;
        for(int i:nums1) map.add(i);
        for(int j:nums2) if(map.contains(j)) {
            ans = j;
            break;
        }
        System.out.println(-1);
    }

    @Override
    public void optimal() {
        int f=0,s=0;
        var ans =-1;
        while(f< nums1.length&& s< nums2.length){
            if(nums1[f]==nums2[s]) {
                ans = nums1[f];
                break;
            } else if (nums1[f]>nums2[s]) {
                s++;
            } else f++;
        }
        System.out.println(ans);
    }
}
