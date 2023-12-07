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
    if(ultU == ultV) return;

    if(size[ultU] < size[ultV]){
      parent[ultU] = ultV;
      size[ultV] += size[ultU];
    }
    else{
      parent[ultV] = ultU;
      size[ultU] += size[ultV];
    }
  }
  
  
  int numberOfProv() {
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                count++;
            }
        }
        return count;
  }
}

class Solution {
    public int findCircleNum(int[][] roads) {
        // O(V + E)
        // S(V)
        // int V = roads.length;
        // int[] vis = new int[V];
        // ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        // for (int i = 0; i < V; i++) {
        //     adj.add(new ArrayList<>());
        // }
        // for (int i = 0; i < V; i++) {
        //     for (int j = 0; j < V; j++) {
        //         if (i == j) continue;
        //         if (roads[i][j] == 1) {
        //             adj.get(i).add(j);
        //             adj.get(j).add(i);
        //         }
        //     }
        // }

        // int count = 0;
        // for (int i = 0; i < V; i++) {
        //     if (vis[i] == 0) {
        //         count++;
        //         dfs(i, adj, vis);
        //     }
        // }
        // return count; 

        int n = roads.length;
        DisJoint ds = new DisJoint(n);

        for(int i = 0; i < n; i++){
          for(int j = 0; j < n; j++){
            if(roads[i][j] == 1){
              ds.unionBySize(i, j);
            }
          }
        }

        return ds.numberOfProv();
    }

    // private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] vis) {
    //     vis[node] = 1;
    //     for (int it : adj.get(node)) {
    //         if (vis[it] == 0) {
    //             dfs(it, adj, vis);
    //         }
    //     }
    // }
}