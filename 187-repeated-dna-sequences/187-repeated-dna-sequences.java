import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i <= s.length() - 10; i++) {
            String tmp = s.substring(i, i + 10);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        
        List<String> answer = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > 1) answer.add(entry.getKey());
        }
        
        return answer;
    }
}