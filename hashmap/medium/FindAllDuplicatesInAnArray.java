package hashmap.medium;

import util.IIntutuionClass;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInAnArray implements IIntutuionClass {
    public static void main(String[] args) {
        var cls = new FindAllDuplicatesInAnArray();
        cls.bruteForce();
    }

    @Override
    public void bruteForce() {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDuplicates(nums));
    }

    public List<Integer> findDuplicates(int[] nums) {
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int t = Math.abs(nums[i]);
            if (nums[t-1] < 0) ans.add(t);
            else nums[t-1] *= -1;
        }
        return ans;
    }
}
