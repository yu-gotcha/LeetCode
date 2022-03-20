class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, answer = Integer.MIN_VALUE;
        
        for(int num : nums) {
            int tmp = max;
            
            max = Math.max(Math.max(max * num, min * num), num);
            min = Math.min(Math.min(tmp * num, min * num), num);
            
            answer = Math.max(answer, max);
        }

        return answer;
    }
}