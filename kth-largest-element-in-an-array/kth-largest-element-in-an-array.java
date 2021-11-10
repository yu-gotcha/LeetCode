class Solution {
    public int findKthLargest(int[] nums, int k) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        
        for(int i = 0; i < nums.length; i++) {
            max = Integer.MIN_VALUE;
            maxIndex = -1;
            for(int j = i; j < nums.length; j++) {
                if(max < nums[j]) {
                    max = nums[j];
                    maxIndex = j;
                }
            }
            
            int tmp = nums[i];
            nums[i] = max;
            nums[maxIndex] = tmp;
            
            if(i + 1 == k) return nums[i];
        }
        
        return nums[k - 1];
    }
}