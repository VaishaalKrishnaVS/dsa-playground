package hashmap.medium;

import util.IIntutuionClass;

import java.util.HashMap;
//leetCode 523
public class ContinuousSubarraySum implements IIntutuionClass {
    public static final int[] nums = {23,2,4,6,7};
    public static final int k = 6;

    public static void main(String[] args) {
        var cls = new ContinuousSubarraySum();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        System.out.println(checkSubarraySum(nums, k));
    }
    public boolean checkSubarraySum(int[] nums, int k) {
        var map =  new HashMap<Integer, Integer>();
        map.put(0,-1);
        var csum = 0;
        for(int i=0;i<nums.length;i++){
            csum+=nums[i];
            csum%=k;
            if(map.containsKey(csum)){
                if(i- map.get(csum)>=2) return true;
            } else map.put(csum, i);

        }
        return false;
    }
}
