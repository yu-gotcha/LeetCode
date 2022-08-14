class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        
        for(int i = 1; i < 4 && i < s.length() - 2 ; i++ ) {
            for(int j = i + 1; j < i + 4 && j < s.length() - 1 ; j++ ) {
                for(int k = j+1 ; k < j + 4 && k < s.length() ; k++) {
                  String s1 = s.substring(0, i), s2 = s.substring(i, j), s3 = s.substring(j, k), s4 = s.substring(k, s.length());
                    
                  if(check(s1) && check(s2) && check(s3) && check(s4)) ans.add(s1 + "." + s2 + "."+ s3 + "." + s4);   
                }
            }
        }
        
        return ans;
    }
    
    boolean check(String str) {
        if(str.length() > 3 || str.length() == 0) return false;
        if(str.charAt(0) == '0' && str.length() > 1) return false;
        if(Integer.parseInt(str) > 255) return false;
        return true;
    }
}