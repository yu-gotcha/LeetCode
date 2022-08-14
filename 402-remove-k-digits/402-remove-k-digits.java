class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> stack = new Stack<>();
        
        for (int index = 0; index < num.length(); index++) {
            int curr = num.charAt(index) - '0';
            
            if (!stack.isEmpty() && stack.peek() > curr) {
                while (!stack.isEmpty() && stack.peek() > curr && k-- > 0) {
                    stack.pop();  
                }
            }
            stack.add(curr);
        }
        
        while (k-- > 0 && !stack.isEmpty()) {
            stack.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        sb.append("0");
        sb.reverse();
        
        String answer = sb.toString();
        
        for (int i = 0; i < answer.length(); i++) {
            if (answer.charAt(i) != '0') {
                return answer.substring(i);
            }
        }
        
        return "0";
    }
}