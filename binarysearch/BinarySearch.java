public class BinarySearch {
    public static void main(String[] args) {
        var nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int target = 9;
        System.out.println(solveN(nums, target));
        System.out.println(solveO(nums, target));

    }

    private static int solveN(int[] nums, int target) {
        var st = 0;
        var en = nums.length - 1;
        while (st <= en) {
            var mid = (st + en) / 2;
            if (nums[mid] > target)
                en = mid - 1;
            else if (nums[mid] < target)
                st = mid + 1;
            else
                return mid;
        }
        return -1;
    }

    private static int solveO(int[] nums, int target) {
        var st = 0;
        var en = nums.length - 1;

        while (st <= en) {
            var mid = st + ((en - st) >>> 1);
            switch (Integer.compare(nums[mid], target)) {
                case 1 -> en = mid - 1;
                case -1 -> st = mid + 1;
                case 0 -> {
                    return mid;
                }
            }
        }

        return -1;
    }

}