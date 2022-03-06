import java.util.*;

class Solution {
    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i=0; i<n; i++)
            map.put(i, new ArrayList<>());
        
        Set<String> set = new HashSet<>();
        
        int count = 0;
        
        for(int[] edge: connections){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
            
            set.add(edge[0]+","+edge[1]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> q = new LinkedList<>();
        
        visited[0] = true;
        
        q.offer(0);
        
        while(!q.isEmpty()){
            int src = q.poll();
            
            Iterator<Integer> it = map.get(src).iterator();
            
            while(it.hasNext()){
                int u = it.next();
                
                if(!visited[u]){
                    visited[u] = true;
                    if(!set.contains(u+","+src))
                        count++;

                    q.offer(u);
                }
            }
        }
        return count;
    }
}