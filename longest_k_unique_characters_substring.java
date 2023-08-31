
class Solution {
    public int longestkSubstr(String s, int k) {
        
        //O(N)
        //S(N)
        int l = 0, r = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int result = -1;
        
        while(r < s.length()){
            char c = s.charAt(r);
            
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            if(map.size() > k){
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                if(map.get(s.charAt(l)) == 0){
                    map.remove(s.charAt(l));
                }
                l++;
            }
            
            if(map.size() == k) result = Math.max(result, r - l + 1);
            
            r++;
        }
        
        return result;
    }
}