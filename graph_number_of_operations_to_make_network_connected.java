class DisJoint{
    int[] parent;
    int[] size;
    int extraCables = 0;

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
            extraCables++;
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
    
    
    int isPossible() {
        int conCables = 0;
        for (int i = 0; i < parent.length; i++) {
            if (i == parent[i]) {
                conCables++;
            }
        }
        return extraCables >= conCables - 1 ? conCables - 1 : -1;
    }
}

class Solution {
    public int makeConnected(int n, int[][] connections) {
      //O(E * 4alpha)
      //S(N)
        DisJoint ds = new DisJoint(n);
        for(int i = 0; i < connections.length; i++){
            ds.unionBySize(connections[i][0], connections[i][1]);
        }
        return ds.isPossible();
    }
}