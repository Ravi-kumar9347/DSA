class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        //O(N)
        //S(N)
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxi = 0;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxi = Math.max(maxi, map.get(num));
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < maxi; i++){
            result.add(new ArrayList<>());
        }

        for(HashMap.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey(), val = entry.getValue();
            for(int i = 0; i < val; i++){
                result.get(i).add(num);
            }
        }

        return result;
    }
}