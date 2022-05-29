class Solution {
    public int shortestBridge(int[][] grid) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        
        boolean flag = false;
        for(int i = 0; i < m; i++) {
            if(flag) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    dfs(grid, i, j, q);
                    flag = true;
                    break;
                }
            }
            
        }
        
        int[] x = {1, -1, 0, 0};
        int[] y = {0, 0, 1, -1};
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            for(int i = 0; i < size; i++){
                int[] indices = q.poll();
                int row = indices[0];
                int col = indices[1];
                
                for(int j = 0; j < 4; j++){
                    int newRow = row + x[j];
                    int newCol = col + y[j];
                    
                    if(isSafe(grid, newRow, newCol, 0)){
                        q.add(new int[]{newRow, newCol});
                        grid[newRow][newCol] = -1;
                    }else if(isSafe(grid, newRow, newCol, 1))
                        return result;
                }
            }
            result++;
        }
        
        return result;
    }

    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        
        if(!isSafe(grid, i, j, 1)) return;
        
        grid[i][j] = -1;
        q.add(new int[]{i, j});
        
        dfs(grid , i + 1, j, q);
        dfs(grid , i - 1, j, q);
        dfs(grid , i, j + 1, q);
        dfs(grid , i, j - 1, q);
    }

    private boolean isSafe(int[][] grid, int i, int j, int target) {
        return 0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == target;
    }
}