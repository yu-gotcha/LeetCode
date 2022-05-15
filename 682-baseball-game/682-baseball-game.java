import java.util.*;

class Solution {
    LinkedList<Integer> list;
    
    public int calPoints(String[] ops) {
        init();
        
        for(String cmd : ops) {
            int elem;
            if(cmd.equals("+")) elem = addBeforeTwoElements();
            else if(cmd.equals("D")) elem = doubleLastElement();
            else if(cmd.equals("C")) {
                delete();
                continue;
            }
            else elem = Integer.parseInt(cmd);
            
            list.add(elem);
        }
        
        int sum = 0;
        for(int element : list) sum += element;
        return sum;
    }
    
    public int addBeforeTwoElements() {
        return list.getLast() + list.get(list.size() - 2);
    }
    
    public int doubleLastElement() {
        return list.getLast() * 2;
    }
    
    public void delete() {
        list.removeLast();
    }
    
    public void init() {
        list = new LinkedList<>();
    }
}