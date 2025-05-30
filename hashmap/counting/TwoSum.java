package hashmap.counting;

import util.IIntutuionClass;

import java.util.HashMap;
// leetCode 01
public class TwoSum implements IIntutuionClass {
    public static void main(String[] args) {
        var cls = new TwoSum();
        cls.bruteForce();
    }

    @Override
    public void bruteForce() {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer>map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            var val = nums[i];
            if(map.containsKey(target-val)) return new int[]{i, map.get(target-val)};
            else map.put(val,i);
        }
        return null;
    }
}
