//수학 길찾기 공식 이용
class Solution {
    public int uniquePaths(int m, int n) {
        n--;
        m--;
        if(n == 0 || m == 0) return 1;
        return (int) (factorialAlike(n + m, n > m ? n + 1: m + 1) / factorialAlike(n > m ? m : n, 1));
    }
    
    public long factorialAlike(int n, int i) {
        if(n == i) return n;
        
        return n * factorialAlike(n - 1, i);
    }
}