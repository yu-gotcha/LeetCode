class Solution {
    public int trap(int[] height) {
        int answer = 0;
        int size = height.length;
        
        int[] left = new int[size], right = new int[size];
        
        left[0] = height[0];
        for(int i = 1; i < size; i++) {
            // 그 전에 높은게 있다면 유지가 되어야 함. 레이저를 쏘는 것과 비슷
            left[i] = Math.max(height[i], left[i - 1]);
        }
        
        right[size - 1] = height[size - 1];
        for(int i = size - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        
        for(int i = 1; i < size - 1; i++) {
            answer += Math.min(left[i] - height[i], right[i] - height[i]);
        }
        
        return answer;
    }
}