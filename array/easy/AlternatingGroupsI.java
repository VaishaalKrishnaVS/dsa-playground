package array.easy;

import util.IBaseClass;
//leetCode 3206
public class AlternatingGroupsI implements IBaseClass {
    public static final int[] colors = {0,1,0,0,1};

    public static void main(String[] args) {
        var cls = new AlternatingGroupsI();
        cls.optimal();
    }
    @Override
    public void bruteForce() {
        int ans = 0;
        int n = colors.length;
        for(int i = 1; i< n -1; i++){
            int c= colors[i];
            int p= colors[i-1];
            int a= colors[i+1];
            if(c!=p && c!=a) ans++;
        }
        int f = colors[0];
        int s = colors[1];
        int l = colors[n-1];
        int sl = colors[n-2];

        if(f!=s && f!=l) ans++;
        if(l!=sl && l!=f) ans++;
        System.out.println(ans);

    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        int ans = 0;
        int n = colors.length;
        for(int i = 0; i< n; i++){
            if(colors[i]!=colors[(i-1+n)%n] && colors[i]!=colors[(i+1)%n]) ans++;
        }
        System.out.println(ans);
    }
}
