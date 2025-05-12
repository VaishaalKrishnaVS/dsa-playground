package array.medium;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.TreeMap;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit implements IIntutuionClass, IOptimalClass {
    public static final int[] nums = {10,1,2,4,7,2};
    public static final int  limit = 5;

    public static void main(String[] args) {
        var cls = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();
        cls.optimal();
    }
    //55/63 :: timelimit exceeded
    @Override
    public void bruteForce() {
        int max = Integer.MIN_VALUE;

        for(int i=0;i< nums.length;i++){
            for(int j=i; j< nums.length;j++){
                if(j-i+1<max) continue;
                if(checkIf(nums, i, j, limit)) max = Math.max(max, j-i+1);
            }
        }
        System.out.println(max);
    }
    public static boolean checkIf(int[] arr, int i, int j, int k){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int el=i;el<=j;el++){
            int v = arr[el];
            if(v<min) min =v;
            if(v>max) max = v;
        }
        return max - min <= k;
    }

    @Override
    public void optimal() {
        var map = new TreeMap<Integer, Integer>();
        int i=0, j=0, ans =0;
        while(j<nums.length){
            map.merge(nums[j],1, Integer::sum );
            int diff =map.lastEntry().getKey() - map.firstEntry().getKey();
            while(i<j && diff>limit){
                if(map.get(nums[i])==1){
                    map.remove(nums[i]);
                } else {
                    map.put(nums[i], map.get(nums[i])-1 );
                }
                i++;
                diff= map.lastEntry().getKey() - map.firstEntry().getKey();
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        System.out.println(ans);
    }
}
