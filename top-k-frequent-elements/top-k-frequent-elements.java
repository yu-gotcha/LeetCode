import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int element : nums)  map.put(element, map.getOrDefault(element, 0) + 1);
        
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());
        
        int[] answer = new int[k];
        
        for(int i = 0; i < k; i++) answer[i] = list.get(i).getKey();
        
        return answer;
    }
}