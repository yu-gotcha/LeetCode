class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if(n < k) return s;

        Stack<Pair<Character, Integer>> stack = new Stack<>();
        
        for(char c : s.toCharArray()){
            if(stack.isEmpty() || stack.peek().getKey() != c) stack.push(new Pair<>(c, 1));
            else {
                Pair<Character, Integer> head = stack.pop();
                stack.push(new Pair<>(head.getKey(), head.getValue() + 1));

                if(stack.peek().getValue()==k) stack.pop();
            }
        }

        String ans = "";
        
        while(!stack.isEmpty()){
            Pair<Character, Integer> head = stack.pop();
            int freq = head.getValue();
            
            while(freq > 0){
                ans = head.getKey() + ans;
                freq--;
            }
        }
        return ans;
    }
}