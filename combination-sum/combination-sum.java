import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        subset(list, candidates, tmp , target, 0);

        return list;
    }
    
    public static void subset(List<List<Integer>> list, int[] nums, List<Integer> tmp, int target, int start) {
        if(tmp.stream().mapToInt(i -> i).sum() == target) {
            list.add(new ArrayList<>(tmp));
        }

        if(tmp.stream().mapToInt(i -> i).sum() > target) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            subset(list, nums, tmp, target, i);
            tmp.remove(tmp.size() - 1);
        }
    }
}