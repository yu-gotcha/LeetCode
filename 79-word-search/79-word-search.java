class Solution {
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
    boolean flag = false;
    
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] != word.charAt(0)) continue;
                boolean[][] visited = new boolean[board.length][board[0].length];
                dfs(board, word, i, j, 0, visited);
                if(flag) return flag;
            }
        }
        return false;
    }
    
    public void dfs(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if(index >= word.length()) return;
        if(flag) return;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length) return;
        if(visited[i][j]) return;
        if(board[i][j] != word.charAt(index)) return;
        
        visited[i][j] = true;
        
        if(index == word.length() - 1){
            flag = true;
            return;
        }
        
        for(int d = 0; d < 4; d++) {
            dfs(board, word, i + dx[d], j + dy[d], index + 1, visited);
        }
        
        visited[i][j] = false;
    }
}