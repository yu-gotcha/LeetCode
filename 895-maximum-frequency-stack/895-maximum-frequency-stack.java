class FreqStack {
    PriorityQueue<PriorityNode> queue;
    HashMap<Integer, Integer> map;
    int i;
    
    public FreqStack() {
        queue =new PriorityQueue<>(
            (o1, o2) -> {
                if(o1.freq != o2.freq) return o2.freq - o1.freq;
                else return o2.index -o1.index;
        });
        
        map= new HashMap<>();
        i=0;
    }
    
    public void push(int val) {
        if(!map.containsKey(val)) map.put(val, 1);
        else map.put(val , map.get(val)+1);
        
        queue.add(new PriorityNode(val,map.get(val), i++));
    }

    public int pop() {
        int x= queue.remove().value;
        map.put(x,map.get(x) - 1);
        return x;
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



/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */