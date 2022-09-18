class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int answer = 0, leftSum = 0, rightSum = 0;
        
        for(int i = 0; i < k; i++) leftSum += cardPoints[i];
        for(int i = 0; i <= k; i ++) {
            answer = Math.max(answer, leftSum + rightSum);
            rightSum += cardPoints[Math.max(0, n - i - 1)];
            leftSum -= cardPoints[Math.max(0, k - i - 1)];
        }
        
        return answer;
    }
}