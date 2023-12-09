import java.util.Arrays;
import java.util.Comparator;
class DisJoint {
    int[] parent;
    int[] size;

    DisJoint(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    int findUPar(int u) {
        if (u == parent[u]) {
            return u;
        }

        return parent[u] = findUPar(parent[u]);
    }

    void unionBySize(int u, int v) {
        int ultU = findUPar(u), ultV = findUPar(v);
        if (ultU == ultV) {
            return;
        }

        if (size[ultU] < size[ultV]) {
            parent[ultU] = ultV;
            size[ultV] += size[ultU];
        } else {
            parent[ultV] = ultU;
            size[ultU] += size[ultV];
        }
    }
}

public class Solution {
    public static int kruskalMST(int n, int[][] edges) {
        //O(MlogM) + O(M)
        //S(N)
        Arrays.sort(edges, Comparator.comparingInt(a -> a[2]));
        DisJoint ds = new DisJoint(n+1);
        int weight = 0;
        for(int[] edge : edges){
            int u = edge[0], v = edge[1], wt = edge[2];
            if(ds.findUPar(u) != ds.findUPar(v)){
                ds.unionBySize(u, v);
                weight += wt;
            }
        }

        return weight;
    }
}