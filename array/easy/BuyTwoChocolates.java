package array.easy;

import util.IBaseClass;

import java.util.Arrays;
//leetCode 2706
public class BuyTwoChocolates implements IBaseClass {
    private static final int[] prices = {4,1,2,2};
    public static final int money = 3;

    public static void main(String[] args) {
        var cls = new BuyTwoChocolates();
        cls.better();
    }
    @Override
    public void bruteForce() {
        Arrays.sort(prices);
        int s = money - prices[0] - prices[1];
        int c = s <0?money:s;
        System.out.println(c);
    }

    @Override
    public void better() {
        int lv = Math.min(prices[0],prices[1]);
        int sl = Math.max(prices[0],prices[1]);

        for (int i=2;i< prices.length;i++){
            int v = prices[i];
            if(v<lv){
                sl=lv;
                lv=v;
            } else if (v<sl) {
                sl =v;
            }
        }
        int i = (money - lv - sl ) < 0 ? money : money - lv - sl;
        System.out.println(i);
    }

    @Override
    public void optimal() {

    }
}
