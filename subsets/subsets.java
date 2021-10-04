import java.util.*;

class Solution {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        subset(list, nums, tmp , 0);

        return list;
    }

    public static void subset(List<List<Integer>> list, int[] nums, List<Integer> tmp, int start) {
        list.add(new ArrayList<>(tmp));

        for (int i = start; i < nums.length; i++) {
            tmp.add(nums[i]);
            subset(list, nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}