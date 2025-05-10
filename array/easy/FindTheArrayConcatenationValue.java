package array.easy;

import util.IBaseClass;
//leetCode 2562
public class FindTheArrayConcatenationValue implements IBaseClass {
    private static final int[]nums = {5,14,13,8,12};


    public static void main(String[] args) {
        var cls = new FindTheArrayConcatenationValue();
        cls.optimal();
    }
    @Override
    public void bruteForce() {
        int n = nums.length;
        int s =0;
        int e = n-1;
        long ans = 0;

        while(s<=e){
            if(s==e) ans+=nums[s];
            else {
                int f = nums[s];
                int l = nums[e];
                int v = Integer.parseInt((f+""+l));
                ans+=v;
            }
            s++;
            e--;
        }
        System.out.println(ans);

    }

    @Override
    public void better() {
        int n = nums.length;
        int s =0;
        int e = n-1;
        long ans = 0;
        StringBuilder sb = new StringBuilder();
        while(s<=e){
            sb.setLength(0);
            if(s==e) ans+=nums[s];
            else {
                sb.append(nums[s]);
                sb.append(nums[e]);
                int v = Integer.parseInt(sb.toString());
                ans+=v;
            }
            s++;
            e--;
        }
        System.out.println(ans);
    }

    @Override
    public void optimal() {
        int n = nums.length;
        int s =0;
        int e = n-1;
        long ans = 0;
        while(s<=e){
            if(s==e) ans+=nums[s];
            else {
                long in = 1;
                int sec = nums[e];
                while (sec>0){
                    in*=10;
                    sec/=10;
                }
                ans+= ((long) nums[s] *in) + nums[e];
            }
            s++;
            e--;
        }
        System.out.println(ans);
    }
}
