class Solution {
    public void moveZeroes(int[] nums) {
        for(int i = 0; i < nums.length - 1; i++) {
            //if(nums[i] != 0) continue;
            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[j] != 0) continue;
                int tmp = nums[j];
                nums[j] = nums[j + 1];
                nums[j + 1] = tmp;
            }
        }
    }
}