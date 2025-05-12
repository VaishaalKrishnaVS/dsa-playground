package array.medium;

import util.IIntutuionClass;
//leetCode 3100
public class WaterBottlesII implements IIntutuionClass {
    public static final int numBottles = 20, numExchange = 1;

    public static void main(String[] args) {
        var cls = new WaterBottlesII();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        var btls = numBottles;
        var ex = numExchange;
        var ans = 0;
        var empty = 0;
        var isBreak=true;
        while (isBreak) {
            if(btls>0) {
                empty+=btls;
                ans+=btls;
                btls=0;
            }
            while(empty>=ex){
                empty-=ex;
                btls++;
                ex++;
            }
            if(btls+empty>=ex){
                ans+=btls;
                empty+=btls;
                btls=0;
            }
            if(btls==0 && empty<ex) isBreak =false;
        }
        System.out.println(ans);

    }
}
