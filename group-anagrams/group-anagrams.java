import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        String[] sorted = new String[strs.length];
        
        for(int i = 0; i < strs.length; i++) {
            char[] tmp = strs[i].toCharArray();
            Arrays.sort(tmp);
            sorted[i] = new String(tmp);
        }
        
        List<List<String>> answer = new ArrayList<>();
        boolean[] check = new boolean[strs.length];
        
        for(int i = 0; i < strs.length; i++) {
            if(check[i]) continue;
            List<String> tmp = new ArrayList<>();
            tmp.add(strs[i]);
            check[i] = true;
            
            for(int j = 0; j < strs.length; j++) {
                if(sorted[i].equals(sorted[j]) && !check[j]) {
                    tmp.add(strs[j]);
                    check[j] = true;
                }
            }
            
            answer.add(tmp);
        }
        
        return answer;
    }
}