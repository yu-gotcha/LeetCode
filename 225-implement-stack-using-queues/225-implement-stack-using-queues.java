class MyStack {
    private Queue<Integer> q;
    

    public MyStack() {
        q = new LinkedList<>();
    }
    
    public void push(int x) {
        q.add(x);
    }
    
    public int pop() {
        int tmp = q.size();
        while(tmp-- > 1) q.add(q.remove());
        int top = q.remove();
        return top;
    }
    
    public int top() {
        int tmp = q.size();
        while(tmp-- > 1) q.add(q.remove());
        int top = q.remove();
        q.add(top);
        return top;
    }
    
    public boolean empty() {
        return q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */