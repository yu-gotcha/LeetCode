import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if(map.get(num) == 2) map.remove(num);
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) return entry.getKey();
        return 0;
        
    }
}