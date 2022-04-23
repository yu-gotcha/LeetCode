class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int depth = (int) baseLog(nums.length, 2) + 1;
        
        while(depth-- > 0) {
            int index = (left + right) / 2;
            if(nums[index] == target) return index;
            if(target > nums[index]) left = index + 1;
            else right = index - 1;
        }
        
        return -1;
    }
    
    public double baseLog(int num, int base) {
        return Math.log(num) / Math.log(base);
    }
}