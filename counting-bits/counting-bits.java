class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n+1];
        
        for(int i = 0; i <= n; i++) {
            answer[i] = counting(i);
        }
        
        return answer;
    }
    
    public int counting(int number) {
        if(number == 0) return 0;
        int count = 0;
        
        while(number > 0) {
            if(number % 2 == 1) count++;
            number /= 2;
        }
        
        return count;
    }
}