class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        
        for(int i=0; i<n; i++) {
            tasks[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        
        Arrays.sort(tasks, (a,b) -> a[0] - b[0]);
        
        int time = tasks[0][0];
        
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> {
            if(a[1] == b[1]) return a[2] - b[2];
            return a[1] - b[1];
        });
        
        int i = 0;
        int[] result = new int[n];
        int index = 0;
        
        while(!minHeap.isEmpty() || i < n) {
            while(i < n && time >= tasks[i][0]) {
                minHeap.add(tasks[i]);
                i++;
            } 
            
            if(!minHeap.isEmpty()) {
                int[] task = minHeap.poll();
                result[index++] = task[2];
                time += task[1];
            } 
            else time = tasks[i][0]; 
        }
        
        return result;
    }
}