package neetcode.slidingwindow;

import util.IBaseClassV2;

public class BestTimeToBuyAndSelStock implements IBaseClassV2<Integer, int[]> {
    public static void main(String[] args) {
        var cls = new BestTimeToBuyAndSelStock();
        System.out.println(cls.intution(new int[]{1,2,4,2,5,7,2,4,9,0,9}));
    }

    @Override
    public Integer intution(int[] prices) {
        int i=0,j= 1;
        int ans = 0;
        if(prices.length==1)return ans;
        while (j< prices.length){
            while(i<j && prices[j]<=prices[i]){
                i++;
            }
            if(prices[j]>prices[i]){
                ans = Math.max(ans, prices[j]-prices[i]);
                j++;
            }
            if(i==j)j++;
        }
        return ans;

    }
}
