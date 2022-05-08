import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums1.length; i++) {
            for(int j = 0; j < nums2.length; j++) {
                if(nums1[i] == nums2[j]) {
                    map.put(nums1[i], j);
                    break;
                }
            }
        }
        
        for(int i = 0; i < nums1.length; i++) {
            nums1[i] = nextGreater(nums1[i], nums2, map.get(nums1[i]) + 1, nums2.length);
        }
        
        return nums1;
    }
    
    public int nextGreater(int num, int[] nums, int start, int n) {
        if(start >= n) return -1;
        
        for(int i = start; i < nums.length; i++) {
            if(nums[i] > num) return nums[i];
        }
        
        return -1;
    }
}