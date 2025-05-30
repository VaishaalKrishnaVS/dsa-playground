package hashmap.counting;

import util.IIntutuionClass;

import java.util.Arrays;
import java.util.HashSet;
// leetCode 349
public class IntersectionOfTwoArrays implements IIntutuionClass {
    public static void main(String[] args) {
        var cls = new IntersectionOfTwoArrays();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int[] nums1 = {1,2,2,1}, nums2 ={2,2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        var map =  new HashSet<Integer>();
        for(int i:nums1)map.add(i);
        var ans = new HashSet<Integer>();
        for(int i:nums2){
            if(map.contains(i)) ans.add(i);
        }
        int[] lis =new int[ans.size()];
        var c=0;
        for(int i:ans)lis[c++]=i;
        return lis;
    }
}
