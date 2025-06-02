package neetcode.slidingwindow;

import util.IBaseClassV2;

import java.util.*;

public class SlidingWindowMaximum implements IBaseClassV2<int[], Object> {
    public static void main(String[] args) {
        var cls = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(cls.optimal(null)));
    }

    @Override
    public int[] intution(Object param) {
        int[]nums ={1,3,-1,-3,5,3,6,7};
        int k = 3;
        var pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        for(int i=0;i<k-1;i++) pq.add(nums[i]);
        int i=0;
        int c = 0;
        int[]ans = new int[nums.length-k+1];
        while(i+k-1< nums.length){
            pq.add(nums[i+k-1]);
            ans[c++]=pq.peek();
            pq.remove(nums[i]);
            i++;
        }
        return ans;
    }

    @Override
    public int[] optimal(Object param) {
        int[]nums ={1,3,-1,-3,5,3,6,7};
        int k = 3;
        var dq = new ArrayDeque<Integer>();
        int i=0,j=0;
        int[] ans = new int[nums.length-k+1];
        int c =0;
        while(j<nums.length){
            while(!dq.isEmpty() && nums[dq.peekLast()]<nums[j]){
                dq.removeLast();
            }
            dq.addLast(j);
            if(i>dq.peekFirst()) dq.removeFirst();
            if(j+1>=k){
                ans[c++] = nums[dq.peekFirst()];
                i++;
            }
            j++;
        }
        return ans;
    }
}
