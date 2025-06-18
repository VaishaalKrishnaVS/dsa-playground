package neetcode.binarysearch;

import util.IBaseClassV2;

public class KokoEatingBananas implements IBaseClassV2<Integer, Object> {
    public static void main(String[] args) {
        var cls = new KokoEatingBananas();
        System.out.println(cls.intution(null));
    }
    @Override
    public Integer intution(Object param) {
        int[]p = new int[]{805306368,805306368,805306368};
        int t = 1000000000;
        int max = Integer.MIN_VALUE;
        for(int i:p){
            max = Math.max(max, i);
        }
        int l = 1;
        int r = max;

        while(l<=r){
            int m = (l+r)/2;
            if(isSol(p,t,m)) r=m;
            else l = m+1;
        }
        return l;
    }
    private boolean isSol(int[]arr, int t, int k){
        int ans = 0;
        for(int i:arr){
            ans+= (int) Math.ceil(i/(double)k);
            if(ans>t) return false;
        }
        return ans<=t;
    }
}
