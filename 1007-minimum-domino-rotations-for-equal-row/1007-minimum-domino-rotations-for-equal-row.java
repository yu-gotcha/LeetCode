class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int length = tops.length;
        int[] top = new int[7], bottom = new int[7], equal = new int[7];
        
        for(int i = 0; i < length; i++) {
            top[tops[i]]++;
            bottom[bottoms[i]]++;
            if(tops[i] == bottoms[i]) equal[tops[i]]++;
        }
        
        int answer = Integer.MAX_VALUE;
        for(int i = 1; i <= 6; i++) {
            if(top[i] + bottom[i] - equal[i] != length) continue;
            int tmp = Math.min(length - top[i], length - bottom[i]);
            answer = Math.min(tmp, answer);
        }
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
}