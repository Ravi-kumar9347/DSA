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
    public int removeStones(int[][] stones) {
        //O(N)
        //S(N)
        int n = stones.length;
        int maxRow = 0, maxCol = 0;
        for(int i = 0; i < n; i++){
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        //rows and cols as nodes, and col shifiting by col + row + 1;
        DisJoint ds = new DisJoint(maxRow + maxCol + 2);
        Map<Integer, Integer> map = new HashMap<>();
        // map for to know which rows and cols are participated in component
        for(int i = 0; i < n; i++){
            int nodeRow = stones[i][0];
            int nodeCol = stones[i][1] + maxRow + 1;
            ds.unionBySize(nodeRow, nodeCol);
            map.put(nodeRow, 1);
            map.put(nodeCol, 1);
        }

        int cnt = 0;
        for(Map.Entry<Integer, Integer> it : map.entrySet()){
            if(ds.findUPar(it.getKey()) == it.getKey()){
                cnt++;
            }
        }

        return n - cnt;
    }
}