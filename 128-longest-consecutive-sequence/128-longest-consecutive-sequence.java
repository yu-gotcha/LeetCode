import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int max = 1, tmp = 1;
        
        for(int i = 1; i < nums.length; i++) {
            while(nums[i] == nums[i - 1] && i + 1 < nums.length) {
                i++;
            }
            if(nums[i] - nums[i - 1] == 1) tmp++;
            else tmp = 1;
            
            max = Math.max(max, tmp);            
        }
        
        return max;
    }
}