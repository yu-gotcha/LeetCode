class Solution {
    public int arrangeCoins(int n) {
        if(n<=1) return n;
        if(n==3) return 2;
        
        long start = 0;
        long end = n/2;
        
        while(start <= end){
            long mid =  start + (end - start) / 2;
            long sum  = (mid * (mid + 1)) / 2;
            if(sum == n){
               return (int) mid;
            }
            else if(sum < n)
            {
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return (int) end;
    }
    
    static class PriorityNode{
        int value;
        int freq;
        int index;
        public PriorityNode(int value, int freq, int index) {
            this.value = value;
            this.freq = freq;
            this.index = index;
        }
}
}