package hashmap.counting;

import util.IIntutuionClass;

import java.util.*;
// leetCode 347
public class TopKFrequentElements implements IIntutuionClass {
    public static void main(String[] args) {
        var cls =  new TopKFrequentElements();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int[] nums = {1,1,1,2,2,3};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(nums,k)));
    }
    public int[] topKFrequent(int[] nums, int l) {
        var map = new HashMap<Integer, Integer>();
        for(int i:nums)map.merge(i,1,Integer::sum);
        var fmap = new TreeMap<Integer, List<Integer>>(Collections.reverseOrder());
        for(var m:map.entrySet()){
            int k = m.getKey();
            int v = m.getValue();
            List<Integer> lis = new ArrayList<>();
            if(fmap.containsKey(v)) lis = fmap.get(v);
            lis.add(k);
            fmap.put(v, lis);
        }
        var lis = new ArrayList<Integer>();
        for(var m:fmap.entrySet()){
            var v = m.getValue();
            if(l<=0)break;
            lis.addAll(v);
            l-=v.size();
        }
        var ans = new int[lis.size()];
        var c= 0;
        for(int i:lis)ans[c++]=i;
        return ans;
    }
}
