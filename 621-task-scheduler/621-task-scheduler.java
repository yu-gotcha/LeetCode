import java.util.*;

class Solution {    
    public int leastInterval(char[] chars, int n) {
        Map<Character, Task> map = new HashMap<>();
        for (char c : chars) {
            if (map.get(c) == null) {
                map.put(c, new Task());
            }
            map.get(c).count++;
        }

        Queue<Task> tasks = new PriorityQueue<>((a, b) -> {
            return Integer.compare(b.count, a.count);
        });
        
        tasks.addAll(map.values());
        
        Queue<Task> waiting = new LinkedList<>();
        
        int cpuTime = 0;

        while (!tasks.isEmpty() || !waiting.isEmpty()) {
            cpuTime++;
            
            if (!waiting.isEmpty() && waiting.peek().nextRun == cpuTime) {
                tasks.add(waiting.remove());
            }
            

            if (tasks.isEmpty()) {
                continue;
            }

            Task task = tasks.remove();
            task.count--;
            if (task.count > 0) {
                task.nextRun = cpuTime + n + 1;
                waiting.add(task);
            }
        }
        
        return cpuTime;
    }
    
    class Task {
        int count = 0;
        int nextRun = 0;
    }
}