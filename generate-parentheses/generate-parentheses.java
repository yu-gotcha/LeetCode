import java.util.*;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        makeParentheses(n, n, "", list);
        
        return list;
    }
    
    public void makeParentheses(int left, int right, String str, List<String> list) {
        if(left == 0 && right == 0) {
            list.add(str);
            return ;
        }
        
        if(left != 0) {
            makeParentheses(left - 1, right, str + "(", list);
        }
        
        if(left < right) {
            makeParentheses(left, right - 1, str + ")", list);
        }
    }
}