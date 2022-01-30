class Solution {
    public void sortColors(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 0; i < nums.length; i++) {
            min = Integer.MAX_VALUE;
            for (int j = i; j < nums.length; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = min;
            nums[minIndex] = tmp;
        }
    }
}