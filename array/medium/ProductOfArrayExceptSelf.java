package array.medium;

import util.IBaseClass;

import java.util.Arrays;

//leetCode 238
public class ProductOfArrayExceptSelf implements IBaseClass {
    private static final int[] nums = {1, 2, 3, 4, 0};

    public static void main(String[] args) {
        var cls = new ProductOfArrayExceptSelf();
        cls.better();
    }

    @Override
    public void bruteForce() {
        int p = 1;
        int z = 0;
        for (int i : nums) {
            if (i != 0) p *= i;
            else z++;
        }
        int n = nums.length;
        int[] ans = new int[n];
        if (z == 1) {
            for (int i = 0; i < n; i++) {
                ans[i] = nums[i] == 0 ? p : 0;
            }
        } else if (z == 0) {
            for (int i = 0; i < n; i++) {
                ans[i] = p / nums[i];
            }
        }
        System.out.println(Arrays.toString(ans));
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        int n = nums.length;
        int[] ans = new int[n];

        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = nums[i - 1] * ans[i - 1];
        }
        int r = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= r;
            r *= nums[i];
        }
        System.out.println(Arrays.toString(ans));
    }
}
