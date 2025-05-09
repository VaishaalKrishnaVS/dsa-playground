package array.easy;

import util.IBaseClass;
//leetCode 1688
public class CountOfMatchesInTournament implements IBaseClass {
    public static final int n = 14;

    public static void main(String[] args) {
        var cls = new CountOfMatchesInTournament();
        cls.bruteForce();
    }
    @Override
    public void bruteForce() {
        int m = n;
        int ans = 0;
        while (m>1){
            if(m%2==0){
                ans+=m/2;
                m=m/2;
            }else {
                ans+=(m-1)/2;
                m = ((m-1)/2) +1;
            }
        }
        System.out.println(ans);
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        System.out.println(n-1);
    }
}
