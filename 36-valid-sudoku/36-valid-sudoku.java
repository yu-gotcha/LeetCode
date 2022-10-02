class Solution {
    public static final int N = 9;
    
    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && checkSquare(board);
    }
    
    public boolean checkRow(char[][] board) {
        for(int i = 0; i < N; i++) {
            boolean[] check = new boolean[N];
            for(int j = 0; j < N; j++) {
                if(board[i][j] == '.') continue;
                int num = Character.getNumericValue(board[i][j]);
                if(check[num - 1]) return false;
                else check[num - 1] = true;
            }
        }
        return true;
    }
    
    public boolean checkColumn(char[][] board) {
        for(int j = 0; j < N; j++) {
            boolean[] check = new boolean[N];
            for(int i = 0; i < N; i++) {
                if(board[i][j] == '.') continue;
                int num = Character.getNumericValue(board[i][j]);
                if(check[num - 1]) return false;
                else check[num - 1] = true;
            }
        }
        return true;
    }
    
    public boolean checkSquare(char[][] board) {
        for(int k = 0; k < 3; k++) {
            for(int l = 0; l < 3; l++) {
                boolean[] check = new boolean[N];
                for(int i = k * 3; i < (k + 1) * 3; i++) {
                    for(int j = l * 3; j < (l + 1) * 3; j++) {
                        if(board[i][j] == '.') continue;
                        int num = Character.getNumericValue(board[i][j]);
                        if(check[num - 1]) return false;
                        else check[num - 1] = true;
                    }
                }
            }
        }
        return true;
    }
}