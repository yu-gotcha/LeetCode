import java.util.*;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );
        PriorityQueue<Passenger> passengers = new PriorityQueue<>(
            (a, b) -> a.to - b.to
        );
        
        initQueue(trips, q);
        int current = 0, sum = 0;
        
        while(!q.isEmpty()) {
            while(!passengers.isEmpty() && passengers.peek().to <= current) {
                sum -= passengers.poll().num;
            }
            
            if(q.peek()[1] > current) {
                current++;
                continue;
            }

            int from = q.peek()[1];
            
            while(!q.isEmpty() && q.peek()[1] == from) {
                int[] trip = q.poll();
                if(sum + trip[0] > capacity) return false;
                passengers.add(new Passenger(trip[0], trip[2]));
                sum += trip[0];
            }
            current++;
        }
        return true;
    }
    
    public void initQueue(int[][] trips, Queue<int[]> q) {
        for(int[] element : trips) {
            q.add(element);
        }
    }
    
    public class Passenger {
        int num, to;
        
        public Passenger(int num, int to) {
            this.num = num;
            this.to = to;
        }
    }
}