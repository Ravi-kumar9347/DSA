class Solution{
    public int[] minQuery(int N, int Q, int A[], List<List<Integer>> Queries){
        //O(Q*N)
        //S(Q)
        HashMap<Pair, Integer> map = new HashMap<>();
        int[] result = new int[Q];
        
        for(int i = 0; i < Q; i++){
            int l1 = Queries.get(i).get(0) - 1, r1 = Queries.get(i).get(1) - 1;
            int v1 = 0;
            Pair p1 = new Pair(l1, r1);
            if(map.containsKey(p1)){
                v1 = map.get(p1);
            }
            else v1 = getVal(A, l1, r1);
            
            int l2 = Queries.get(i).get(2) - 1, r2 = Queries.get(i).get(3) - 1;
            int v2 = 0;
            Pair p2 = new Pair(l2, r2);
            if(map.containsKey(p2)){
                v2 = map.get(p2);
            }
            else v2 = getVal(A, l2, r2);
            
            result[i] = v1 | v2;
            
            map.put(p1, v1);
            map.put(p2, v2);
        }
        
        return result;
    }
    
    private static int getVal(int[] A, int l, int r){
        int val = A[l];
        for(int i = l+1; i <= r; i++){
            val = val & A[i];
        }
        return val;
    }
}

class Pair{
    int first, second;
    Pair(int first, int second){
        this.first = first;
        this.second =second;
    }
}