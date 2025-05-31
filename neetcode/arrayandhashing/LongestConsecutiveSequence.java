package neetcode.arrayandhashing;

import util.IBaseClassV2;

import java.util.Arrays;
import java.util.PriorityQueue;

public class LongestConsecutiveSequence implements IBaseClassV2<Integer, int[]> {
    public static void main(String[] args) {
        var cls = new LongestConsecutiveSequence();
        System.out.println(cls.intution(new int[]{9,1,4,7,3,-1,0,5,8,-1,6}));
    }
    @Override
    public Integer intution(int[] nums) {
        if(nums.length==0) return 0;
        var pq = new PriorityQueue<Integer>();
        for(int i:nums)pq.add(i);
        int ans = Integer.MIN_VALUE;
        int temp = 1;
        int pre = pq.poll();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            if(cur==pre) continue;
            if(cur==pre+1) {
                temp++;
            }
            else {
                ans = Math.max(ans, temp);
                temp=1;
            }
            pre=cur;

        }
        return Math.max(ans, temp);
    }

}
