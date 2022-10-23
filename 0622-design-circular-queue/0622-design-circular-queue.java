class MyCircularQueue {
    int[] q;
    int front, rear, size, capability;

    public MyCircularQueue(int k) {
        q = new int[k];
        front = 0;
        rear = 0;
        size = 0;
        capability = k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()) return false;
        q[rear] = value;
        rear = (rear + 1) % capability;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()) return false;
        q[front] = 0;
        front = (front + 1) % capability;
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : q[front];
    }
    
    public int Rear() {
        return size == 0 ? -1 : q[rear - 1 < 0 ? capability - 1 : rear - 1];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return front == rear && size == capability;
    }
    
    public void printQ() {
        for(int elem: q) {
            System.out.print(elem + ", ");
        }
        System.out.println();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */