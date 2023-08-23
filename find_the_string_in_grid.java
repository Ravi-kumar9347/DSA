class Solution
{
    //O(N * M * K)
    //S(1)
    private static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    private static boolean isValid(int i, int j, int p, int n, int m, char[][] grid, String word){
        if(i < 0 || i >= n || j < 0 || j >= m){
            return false;
        }
        return grid[i][j] == word.charAt(p);
    }
    
    private static boolean helper(int i, int j, int dir, int p, int n, int m, char[][] grid, String word){
        if(p == word.length() - 1) return true;
        
        if(isValid(i + dr[dir], j + dc[dir], p + 1, n, m, grid, word)){
            return helper(i + dr[dir], j + dc[dir], dir, p + 1, n, m, grid, word);
        }
        
        return false;
    }
    
    public int[][] searchWord(char[][] grid, String word)
    {
        int n = grid.length;
        int m = grid[0].length;
        
        List<List<Integer>> ans = new ArrayList<>();    
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 8; k++) {
                    if (isValid(i, j, 0, n, m, grid, word) && helper(i, j, k, 0, n, m, grid, word)) {
                        List<Integer> t = new ArrayList<>();
                        t.add(i);
                        t.add(j);
                        ans.add(new ArrayList<>(t));
                        break;
                    }
                }
            }
        }
        
        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            result[i][0] = ans.get(i).get(0);
            result[i][1] = ans.get(i).get(1);
        }

        return result;
    }
}
