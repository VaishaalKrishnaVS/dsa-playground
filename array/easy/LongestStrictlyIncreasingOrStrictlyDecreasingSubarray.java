package array.easy;

import util.IBaseClass;
//leetCode3105
public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray implements IBaseClass {
    public static final int[] nums = {1,4,3,3,2};

    public static void main(String[] args) {
        var cls = new LongestStrictlyIncreasingOrStrictlyDecreasingSubarray();
        cls.optimal();
    }
    @Override
    public void bruteForce() {
        var l = Integer.MIN_VALUE;
        var n = nums.length;
        for(int i=0;i<n;i++){
            for (int j=i;j<n;j++){
                if(strictlyIncreasing(nums, i,j)||strictlyDecreasing(nums,i,j)) l = Math.max(l, j-i+1);
            }
        }
        System.out.println(l);
    }
    private static boolean strictlyIncreasing(int[] arr, int s, int e){
        if(s==e) return true;
        for(int i = s+1;i<=e;i++){
            if(arr[i]<=arr[i-1]) return false;
        }
        return true;
    }
    private static boolean strictlyDecreasing(int[] arr, int s, int e){
        if(s==e) return true;
        for(int i=s+1;i<=e;i++){
            if(arr[i]>=arr[i-1]) return false;
        }
        return true;
    }

    @Override
    public void better() {
        var ans = 1;
        var inc = 1;
        var dec =1;
        for(int i = 1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                inc++;
                dec=1;
            } else if(nums[i]<nums[i-1]){
                inc=1;
                dec++;
            } else {
                inc=1;
                dec=1;
            }
            ans = Math.max(ans, Math.max(inc,dec));
        }
        System.out.println(ans);
    }

    @Override
    public void optimal() {
        int ans=1, inc=1, dec =1;
        for (int i=1;i<nums.length;i++){
            int d = Integer.compare(nums[i], nums[i-1] );
            inc = d == 1? inc+1:1;
            dec = d ==-1?dec+1:1;
            ans = Math.max(ans, Math.max(inc, dec));
        }
        System.out.println(ans);
    }
}
