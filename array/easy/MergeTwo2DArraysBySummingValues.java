package array.easy;

import util.IBaseClass;

import java.util.ArrayList;
import java.util.Arrays;

//leetCode 2570
public class MergeTwo2DArraysBySummingValues implements IBaseClass {
    public static final int[][] nums1 = {{1,2},{2,3},{4,5}}, nums2 = {{1,4},{3,2},{4,1}};

    public static void main(String[] args) {
        var cls = new MergeTwo2DArraysBySummingValues();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int[] map = new int[1001];
        for(int[]ar:nums1){
            map[ar[0]]+=ar[1];
        }
        for(int[]ar:nums2){
            map[ar[0]]+=ar[1];
        }
        var ans = new ArrayList<int[]>();
        for(int i=0;i<1001;i++){
            if(map[i]!=0){
                ans.add(new int[]{i,map[i]});
            }
        }
        var aans = new int[ans.size()][2];
        for(int i=0;i<ans.size();i++){
            aans[i] = ans.get(i);
        }
        System.out.println(Arrays.deepToString(aans));
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
