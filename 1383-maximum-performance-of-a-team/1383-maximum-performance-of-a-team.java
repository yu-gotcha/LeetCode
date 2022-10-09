class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int[][] engineers = new int[n][2];
        for(int i = 0; i < n; i++) {
            engineers[i][0] = speed[i];
            engineers[i][1] = efficiency[i];
        }
        Arrays.sort(engineers, (a, b) -> b[1] - a[1]);
        
        long max = 0, sum = 0;
        for(int i =0; i < n; i++) {
            while(pq.size() >= k) sum -= pq.remove();
            
            pq.add(engineers[i][0]);
            sum += engineers[i][0];
            max = Math.max(sum * engineers[i][1], max);
        }
        
        return (int)(max % (long)(Math.pow(10, 9) + 7));
    }
}