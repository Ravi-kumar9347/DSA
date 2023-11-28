class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int v) {
        //O(V)
        //S(1)
        int result = 0;
        for(ArrayList<Integer> a : adj){
            result += a.size();
        }
        return result;
    }
    
}