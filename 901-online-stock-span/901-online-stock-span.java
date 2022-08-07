class StockSpanner {
    ArrayList<Integer> list;
    Stack<Integer> stack;
    
    public StockSpanner() {
        list = new ArrayList<Integer>();
        stack = new Stack<Integer>();
    }
    
    public int next(int price) {
        int current_id = list.size();
        
        while(!stack.isEmpty() && list.get(stack.peek())<=price) {
            stack.pop();
        }
        
        int st_index = -1;
        if(!stack.isEmpty()) {
            st_index = stack.peek();
        }
        
        list.add(price);
        stack.push(list.size() - 1);
        
        return current_id - st_index;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */