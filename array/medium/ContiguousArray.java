package array.medium;

import util.IBaseClass;

import java.util.HashMap;
//leetCode 525
public class ContiguousArray implements IBaseClass {
    public static final int[] nums = {0,1,1,1,1,1,0,0,0};

    public static void main(String[] args) {
        var cls = new ContiguousArray();
        cls.optimal();
    }
    @Override
    public void bruteForce() {

    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        int max = Integer.MIN_VALUE;
        var map = new HashMap<Integer, Integer>();
        map.put(0,-1);
        int cv = 0;
        for(int i=0;i<nums.length;i++){
            cv += nums[i]==0?-1:1;
            if(map.containsKey(cv)){
                max = Math.max(max, i-map.get(cv));
            } else map.put(cv, i);
        }
        System.out.println(max);
    }
}
