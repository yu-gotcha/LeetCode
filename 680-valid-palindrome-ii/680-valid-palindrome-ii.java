class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return check(s, l, r - 1) || check(s, l + 1, r);
            else {
                l++;
                r--;
            }
        }
        
        return true;
    }

    public boolean check(String s, int l, int r) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}