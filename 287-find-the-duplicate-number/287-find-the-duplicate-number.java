class Solution {
    public int findDuplicate(int[] nums) {
        int[] origin = new int[nums.length + 1];
        
        for(int i = 0; i < nums.length; i++) {
            origin[nums[i]]++;
            if(origin[nums[i]] == 2) origin[0] = nums[i];
        }
        
        return origin[0];
    }
}