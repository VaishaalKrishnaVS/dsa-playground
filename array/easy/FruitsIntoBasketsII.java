package array.easy;

import util.IBaseClass;
//leetCode 3477
public class FruitsIntoBasketsII implements IBaseClass {
    public static final int[] fruits = {4,2,5}, baskets = {3,5,4};

    public static void main(String[] args) {
        var cls = new FruitsIntoBasketsII();
        cls.bruteForce();
    }


    @Override
    public void bruteForce() {
        var ans = 0;
        for(int i: fruits){
            var maybe = true;
            for(int j=0;j<baskets.length;j++){
                if(i<=baskets[j]){
                    baskets[j]=-1;
                    maybe=false;
                    break;
                }
            }
            if(maybe)ans++;
        }
        System.out.println(ans);
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {

    }
}
