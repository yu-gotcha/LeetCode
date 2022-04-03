class Solution {
    public int searchInsert(int[] nums, int target) {
        int mid;
        int left = 0, right = nums.length - 1;
        
        while(left < right) {
            if(nums[left] == target) return left;
            if(nums[right] == target) return right;
            
            mid = (left + right) / 2;
            if(mid == left || mid == right) break;
            
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) right = mid;
            else left = mid;
        }
        
        if(target < nums[left]) return left;
        else if(target > nums[right]) return right + 1;
        else return right;    
    }
}