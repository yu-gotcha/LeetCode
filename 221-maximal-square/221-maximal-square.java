class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0, n = matrix.length, m = matrix[0].length;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(matrix[i][j] == '0') continue;
                int unit = 1;
                while(checkSquare(i, j, unit, matrix)) {
                    unit++;
                }
                max = Math.max(unit - 1, max);
            }
        }
        
        return max * max;
    }
    
    public static boolean checkSquare(int x, int y, int unit, char[][] matrix) {
        int nx = x + unit - 1, ny = y + unit - 1;
        if(nx >= matrix.length || ny >= matrix[0].length) return false;
        for(int i = x; i < x + unit; i++) {
            if(matrix[i][ny] == '0') return false;
        }
        for(int j = y; j < y + unit; j++) {
            if(matrix[nx][j] == '0') return false;
        }

        return true;
    }
}