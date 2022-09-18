class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[][] dp = new long[2][nums.length];
        dp[0][nums.length - 1] = nums[nums.length - 1];
        long max = dp[0][nums.length-1], min = dp[1][nums.length - 1];
        
        for(int i = nums.length - 2; i >= 0; i--){
            dp[0][i] = nums[i];
            dp[0][i] = Math.max(nums[i] - min, dp[0][i]);
            dp[1][i] = Math.min(nums[i] - max, dp[1][i]);
            min = Math.min(dp[1][i], min);
            max = Math.max(dp[0][i], max);
        }
        
        return max;
    }
}