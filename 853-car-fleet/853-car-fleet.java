class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Car> list = new ArrayList<>();
        
        for(int i = 0; i < position.length; i++) {
            list.add(new Car(position[i], (double)(target - position[i]) / (double)speed[i]));
        }
        list.sort((a, b) -> a.position - b.position);
        
        Stack<Double> st = new Stack<>();
        
        int index = position.length - 1, fleet = 0;
        while(index >= 0) {
            if(st.isEmpty()) {
                fleet++;
            }
            
            if (st.isEmpty() || st.peek() >= list.get(index).time) {
                st.push(list.get(index).time);
                index--;
            }
            else {
                while(!st.isEmpty() && st.peek() < list.get(index).time) st.pop();
            }
        }
        
        return fleet;
    }
    
    public class Car {
        int position;
        double time;
        
        Car(int position, double time) {
            this.position = position;
            this.time = time;
        }
    }
}