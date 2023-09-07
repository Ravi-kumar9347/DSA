
class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        //O(100000 + 100000 * 10000)
        //S(100000)
        if(start == end) return 0;
        int n = arr.length;
        
        int mod = (int)1e5;
        int[] dis = new int[mod];
        Arrays.fill(dis, (int)1e9);
        dis[start] = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        
        while(!q.isEmpty()){
            int node = q.remove();
            
            for(int i : arr){
                int child = (node * i) % mod;
                if(dis[child] > dis[node] + 1){
                    dis[child] = dis[node] + 1;
                    
                    if(child == end) return dis[child];
                    
                    q.add(child);
                }
            }
        }
        return -1;
    }
}