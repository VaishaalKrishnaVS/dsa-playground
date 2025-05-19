package hashmap.easy;

import util.IIntutuionClass;
import util.IOptimalClass;

//leetCode 268
public class MissingNumber implements IIntutuionClass, IOptimalClass {
    public static final int[]  nums = {3,0,1};
    @Override
    public void bruteForce() {
        int[]map = new int[nums.length+1];
        for(int i=0;i< nums.length;i++){
            map[nums[i]]++;
        }
        int ans =0;
        for(int i=0;i< map.length;i++){
            if(map[i]==0) ans = i;
        }
        System.out.println(ans);
    }

    @Override
    public void optimal() {
        int es = (nums.length *(nums.length+1)) /2;
        int cs = 0;
        for(int i:nums)cs+=i;
        System.out.println(es-cs);
    }
}
