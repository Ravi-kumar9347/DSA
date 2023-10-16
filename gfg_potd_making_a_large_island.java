
class Solution{
    static HashMap<Integer, Integer> map = new HashMap<>();
    public int largestIsland(int n,int[][] grid) 
    {
        // code here
        //O(N*N)
        //S(N*N)
        int name = 2;
        boolean vis[][] = new boolean[n][n];
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    int count = dfs(i, j, grid, vis, name, n);
                    map.put(name, count);
                    name++;
                }
            }
        }
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    int d = (i + 1 < n) ? grid[i + 1][j] : 0;
                    int u = (i - 1 >= 0) ? grid[i - 1][j] : 0;
                    int r = (j + 1 < n) ? grid[i][j + 1] : 0;
                    int l = (j - 1 >= 0) ? grid[i][j - 1] : 0;
                    
                    Set<Integer> set = new HashSet<>();
                    set.add(d); set.add(u); set.add(r); set.add(l);
                    int result = 1;
                    for(int val : set){
                        result += map.getOrDefault(val, 0);
                    }
                    
                    ans = Math.max(ans, result);
                }
            }
        }
        
        return ans == 0 ? n * n : ans;
    }
    
    private static int dfs(int i, int j, int[][] grid, boolean vis[][], int name, int n){
        if(i < 0 || j < 0 || i >= n || j >= n || grid[i][j] == 0 || vis[i][j]) return 0;
        vis[i][j] = true;
        grid[i][j] = name;
        int count = 1
                    + dfs(i + 1, j, grid, vis, name, n)
                    + dfs(i - 1, j, grid, vis, name, n)
                    + dfs(i, j + 1, grid, vis, name, n)
                    + dfs(i, j - 1, grid, vis, name, n);
        
        return count;
    }
}
