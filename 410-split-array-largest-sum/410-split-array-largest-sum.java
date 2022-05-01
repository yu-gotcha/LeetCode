import java.util.*;

class Solution {
    public int splitArray(int[] nums, int m) {
        int minSum = 0, maxSum = 0;

        for (int num : nums) {
            minSum = Math.max(minSum, num);
            maxSum += num;
        }

        int lo = minSum, hi = maxSum;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canSplit(mid, nums, m)) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    public boolean canSplit(int targetSum, int[] nums, int m) {
        int count = 1, sum = 0;

        for (int num : nums) {
            sum += num;

            if (sum > targetSum) {
                count++;
                sum = num;

                if (count > m) {
                    return false;
                }
            }
        }

        return true;
    }
}