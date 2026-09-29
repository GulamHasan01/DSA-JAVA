class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        if ((m + n - 1) % 2 != 0) return false;
        if (grid[0][0] == ')') return false;
        
        boolean[][][] memo = new boolean[m][n][(m + n) / 2 + 1];
        return dfs(grid, 0, 0, 0, memo);
    }

    private boolean dfs(char[][] grid, int i, int j, int balance, boolean[][][] memo) {
        if (i >= grid.length || j >= grid[0].length) return false;

        if (grid[i][j] == '(') {
            balance++;
        } else {
            balance--;
        }

        if (balance < 0 || balance >= memo[0][0].length) return false;

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return balance == 0;
        }

        if (memo[i][j][balance]) return false;

        boolean foundPath = dfs(grid, i + 1, j, balance, memo) || dfs(grid, i, j + 1, balance, memo);
        
        if (!foundPath) {
            memo[i][j][balance] = true;
        }
        
        return foundPath;
    }
}
