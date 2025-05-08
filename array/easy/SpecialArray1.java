package array.easy;

import util.IBaseClass;

//leetCode 3151
public class SpecialArray1 implements IBaseClass {
    private static final int[] nums = {4, 3, 1, 6};

    public static void main(String[] args) {
        var cls = new SpecialArray1();
        cls.better();
    }

    @Override
    public void bruteForce() {
        int n = nums.length;
        if (n == 1) {
            System.out.println(true);
            return;
        }
        if (n == 2) {
            System.out.println(validatePair(nums[0], nums[1]));
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (validatePair(nums[i - 1], nums[i]) && validatePair(nums[i], nums[i + 1])) continue;
            System.out.println(false);
            return;
        }
        System.out.println(true);
    }

    private static boolean validatePair(int a, int b) {
        if (a % 2 == 0) {
            return b % 2 != 0;
        } else {
            return b % 2 == 0;
        }
    }

    @Override
    public void better() {

    }

    @Override
    public void optimal() {
        int n = nums.length;
        if (n == 1) {
            System.out.println(true);
            return;
        }
        for (int i = 1; i < n; i++) {
            if ((nums[i] + nums[i - 1]) % 2 == 0) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}
