class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length <= 1) return 0;
        
        int pivot = 0;
        int left = 0, right = 0;
        
        for(int i = 1; i < nums.length; i++) right += nums[i];
        
        while(pivot < nums.length) {
            if(left == right) return pivot;
            
            left += nums[pivot];
            if(pivot + 1 < nums.length) right -= nums[pivot + 1];
            
            pivot++;
        }
        
        return -1;
    }
}