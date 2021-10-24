class Solution {
    public int countSubstrings(String s) {
        int answer = s.length();
        
        for(int i = 0; i < s.length(); i++) {
            answer += check(s, i, i + 1) + check(s, i - 1, i + 1);
        }
        
        return answer;
    }
    
    public static int check(String str, int left, int right) {
        int count = 0;
        while(left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
}