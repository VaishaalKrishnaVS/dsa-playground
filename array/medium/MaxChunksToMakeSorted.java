package array.medium;

import util.IOptimalClass;

public class MaxChunksToMakeSorted implements IOptimalClass {
    public static final int[] arr = {4,3,2,1,0};
//leetCode 769
    public static void main(String[] args) {
        var cls = new MaxChunksToMakeSorted();
        cls.optimal();
    }
    @Override
    public void optimal() {
        int ans =0;
        int ps =0;
        int is =0;
        for(int i=0;i<arr.length;i++){
            ps+=arr[i];
            is+=i;
            if(ps==is){
                ans++;
            }
        }
        System.out.println(ans);
    }
}
