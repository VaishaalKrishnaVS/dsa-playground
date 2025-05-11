package array.medium;

import util.IIntutuionClass;
import util.IOptimalClass;

import java.util.PriorityQueue;
import java.util.TreeMap;

//leetCode 1296
public class DivideArrayInSetsOfKConsecutiveNumbers implements IIntutuionClass, IOptimalClass {
    public static final int[] nums = {1,1,1,2,3,3};
    public static final int k = 3;

    public static void main(String[] args) {
        var cls = new DivideArrayInSetsOfKConsecutiveNumbers();
        cls.optimal();
    }
    @Override
    public void bruteForce() {
        if(nums.length%k != 0) {
            System.out.println(false);
            return;
        }
        var heap = new PriorityQueue<Integer>();
        for(int i:nums) heap.add(i);

        while (!heap.isEmpty()){
            int c =k;
            int min = heap.poll();
            while(c-->1){
                if(!heap.isEmpty() && heap.contains(min+1)){
                    min++;
                    heap.remove(min);
                }
                else {
                    System.out.println(false);
                    return;
                }
            }
        }
        System.out.println(true);

    }

    @Override
    public void optimal() {
        if(nums.length%k != 0) {
            System.out.println(false);
            return;
        }
        var map = new TreeMap<Integer, Integer>();
        for(int i: nums) map.merge(i, 1,Integer::sum);

        for(var mapElement: map.entrySet()){
            int f = mapElement.getValue();
            int ky = mapElement.getKey();
            if(f==0) continue;
            while (f-->0){
                for(int i=ky;i<k+ky;i++){
                    if(map.containsKey(i) && map.get(i)!=0){
                        map.put(i, map.get(i)-1);
                    }
                    else {
                        System.out.println(false);
                        return;
                    }
                }
            }
        }
        System.out.println(true);

    }
}
