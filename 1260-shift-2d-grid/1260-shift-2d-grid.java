class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        List<List<Integer>> list = new ArrayList<>();
        
        int x = n - 1, y = m - k;
        
        while(y < 0) {
            y += m;
            x--;
            if(x < 0) x = n - 1;
        }
        if(k == 0) y = 0;
        
        for(int i = 0; i < n; i++) {
            List<Integer> tmp = new ArrayList<>();
            for(int j = 0; j < m; j++) {
                tmp.add(grid[x][y++]);
                if(y >= m) {
                    y = 0;
                    x++;
                }
                if(x >= n) x = 0;
            }
            list.add(tmp);
        }
        
        return list;
    }
}