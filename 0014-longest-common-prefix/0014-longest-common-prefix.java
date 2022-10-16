class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs, (a, b) -> a.length() - b.length());
        int n = strs.length;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < strs[0].length(); i++) {
            boolean flag = true;
            for(int j = 0; j < n; j++) {
                if(strs[0].charAt(i) != strs[j].charAt(i)) {
                    flag = false;
                    return sb.toString();
                }
            }
            sb.append(strs[0].charAt(i));
        }
        
        return sb.toString();
    }
}