import java.util.*;

class Solution {
    
     public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> num = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            StringBuilder numSb = new StringBuilder(); 
            while(Character.isDigit(current)) {
                numSb.append(current);
                current = s.charAt(++i);
            }
            
            if(numSb.length() != 0) {
                num.push(Integer.parseInt(numSb.toString()));
                stack.push(current);
                continue;
            }
             
            if(current == ']') {
                StringBuilder sb = new StringBuilder();
                int count = num.pop();
                while(true) {
                    char tmp = stack.pop();
                    if(tmp == '[') break;
                    sb.append(tmp);
                }
                String tmp = sb.toString();
                for(int j = 0; j < count - 1; j++) sb.append(tmp);
                pushBack(sb.reverse().toString(), stack);
                continue;
            }
            
            stack.push(current);
        }
         
        return makeString(stack);
    }
    
    public void pushBack(String str, Stack<Character> stack) {
        for(int i = 0; i < str.length(); i++) {
            stack.push(str.charAt(i));
        }
    }
    
    public String makeString(Stack<Character> stack) {
        StringBuilder sb = new StringBuilder();
        
        for(char ch : stack) sb.append(ch);
        
        return sb.toString();
    }
}