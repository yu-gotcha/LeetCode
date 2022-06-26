import java.util.*;

class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i = 0; i < n; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;

            for(int j = i + 1; j < n; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                else {
                    int left = j + 1, right = n - 1;

                    while(left < right){
                        long sum = (long)nums[i] + nums[j] + nums[left] + nums[right];

                        if(sum > target) right--;
                        else if(sum < target) left++;
                        else {
                            answer.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));

                            if(nums[left] == nums[right]) break;
                            else {
                                int x = nums[left];
                                int y = nums[right];

                                while(nums[left] == x) left++;
                                while(nums[right] == y) right--;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}