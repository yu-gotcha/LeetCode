class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        boolean flag;
        for(int i = 0; i < temperatures.length; i++) {
            int current = temperatures[i];
            flag = false;
            for(int j = i + 1; j < temperatures.length; j++) {
                if(current < temperatures[j]) {
                    flag = true;
                    answer[i] = j - i;
                    break;
                }
            }
            if(!flag) answer[i] = 0;
        }
        
        return answer;
    }
}