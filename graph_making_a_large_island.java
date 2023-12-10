class DisJoint{
    int[] parent;
    int[] size;

    DisJoint(int n){
        parent = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }  

    int findUPar(int u){
        if(u == parent[u]){
        return u;
        }

        return parent[u] = findUPar(parent[u]);
    }

    void unionBySize(int u, int v){
        int ultU = findUPar(u), ultV = findUPar(v);
        if(ultU == ultV){
            return;
        }

        if(size[ultU] < size[ultV]){
            parent[ultU] = ultV;
            size[ultV] += size[ultU];
        }
        else{
            parent[ultV] = ultU;
            size[ultU] += size[ultV];
        }
    }
}

class Solution {

    private static boolean isValid(int x, int y, int n){
        if(x >= 0 && x < n && y >= 0 && y < n){
            return true;
        }
        return false;
    }

    public int largestIsland(int[][] grid) {
        //O(N*N)
        //S(N*N)
        int n = grid.length;
        DisJoint ds = new DisJoint(n*n);

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        int cntOnes = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 1){
                    cntOnes++;
                    for(int k = 0; k < 4; k++){
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        if(isValid(nrow, ncol, n) == true && grid[nrow][ncol] == 1){
                            ds.unionBySize(i * n + j, nrow * n + ncol);
                        } 
                    }
                }
            }
        }

        int ans = 0, cntZeroes = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(grid[i][j] == 0){
                    cntZeroes++;
                    int cnt = 0;
                    HashSet<Integer> set = new HashSet<>();
                    for(int k = 0; k < 4; k++){
                        int nrow = i + dr[k];
                        int ncol = j + dc[k];
                        if(isValid(nrow, ncol, n) == true && grid[nrow][ncol] == 1){
                            int ind = ds.findUPar(nrow * n + ncol);
                            if(set.contains(ind)) continue;
                            set.add(ind);
                            cnt += ds.size[ind];
                        }
                    }

                    ans = Math.max(ans, cnt);
                }
            }
        }
        if(cntZeroes == 0) return cntOnes++;
        return ans + 1;
    }
}