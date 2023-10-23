class Solution {
    static int maximizeFlavors(int c[],int k) {
        int n = c.length;
        //O(N)
        //S(N)
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(c[i], map.getOrDefault(c[i], 0) + 1);
        }
        
        int l = 0, r = 0;
        int ans = 0;
        while(r < n){
            if(r < k - 1){
                map.put(c[r], map.get(c[r]) - 1);
                if(map.get(c[r]) <= 0){
                    map.remove(c[r]);
                }
                r++;
                continue;
            }
            
            map.put(c[r], map.get(c[r]) - 1);
            if(map.get(c[r]) <= 0){
                map.remove(c[r]);
            }
            ans = Math.max(ans, map.size());
            map.put(c[l], map.getOrDefault(c[l], 0) + 1);
            l++;
            r++;
        }
        
        return ans;
    }
}
     