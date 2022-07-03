class Solution {    
    public boolean canJump(int[] nums) {
        if(nums.length <= 1) return true;
        int distance = 0;
        
        for (int i = 0; i <= distance; i++) {
            distance = Math.max(distance, i + nums[i]);
            // 도달 확인만 하면 끝
            if (distance >= nums.length - 1) return true;
        }
        
        return false;
    }
}