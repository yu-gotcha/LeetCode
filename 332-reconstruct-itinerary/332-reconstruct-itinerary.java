class Solution {
    HashMap<String, PriorityQueue<String>> map;
    LinkedList<String> list;
    
    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        list = new LinkedList<>();
        
        for(List<String> ticket: tickets){
            PriorityQueue<String> temp = map.getOrDefault(ticket.get(0), new PriorityQueue<>());
            temp.add(ticket.get(1));
            map.put(ticket.get(0), temp);
        }
        dfs("JFK");
        
        return list;
    }
    
    public void dfs(String start){
        PriorityQueue<String> target = map.get(start);
        
        while(target != null && !target.isEmpty()){
            String temp = target.remove();
            dfs(temp);
        }
        list.addFirst(start);
    }
}