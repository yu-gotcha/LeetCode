import java.util.*;

class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int limit = costs.length / 2;
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> Math.abs(b[0] - b[1]) - Math.abs(a[0] - a[1])
        );
        for(int[] cost : costs) q.add(cost);
        City a = new City(), b = new City();
        
        while(!q.isEmpty()) {
            int[] cost = q.poll();
            
            if(a.n == limit) b.sum += cost[1];
            else if(b.n == limit) a.sum += cost[0];
            
            else {
                if(cost[0] < cost[1]) {
                    a.sum += cost[0];
                    a.n++;
                }
                else {
                    b.sum += cost[1];
                    b.n++;
                }
            }
        }
        
        return a.sum + b.sum;
    }
    
    public class City {
        int sum, n;
        
        public City() {
            sum = 0;
            n = 0;
        }
    }
}