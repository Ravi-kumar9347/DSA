class Solution {
    public static boolean isFrequencyUnique(int n, int[] arr) {
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++){
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);
        }
        
        Set<Integer> valueSet = new HashSet<>();
        
        for(Map.Entry<Integer, Integer> entry : mp.entrySet()){
            if(valueSet.contains(entry.getValue())) return false;
            valueSet.add(entry.getValue());
        }
        return true;
    }
}