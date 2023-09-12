class Solution {
    public int minDeletions(String s) {
        //O(N)
        //S(N)
        int n = s.length();
        HashMap<Character, Integer> countMap = new HashMap<>();

        for(int i = 0; i < n; i++){
            countMap.put(s.charAt(i), countMap.getOrDefault(s.charAt(i), 0) + 1);
        }

        HashSet<Integer> countSet = new HashSet<>();
        int ans = 0;
        for(Map.Entry<Character, Integer> entry : countMap.entrySet()){
            int val = entry.getValue();
            while(countSet.contains(val) && val != 0){
                ans++;
                val--;
            }
            if(val != 0){
                countSet.add(val);
            } 
        }

        return ans;
    }
}