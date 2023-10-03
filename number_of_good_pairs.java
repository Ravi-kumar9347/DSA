class Solution {
    public int numIdenticalPairs(int[] nums) {
        //O(N)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int num : nums){
            if(map.containsKey(num)){
                result += map.get(num);
                map.put(num, map.get(num) + 1);
            }
            else map.put(num, 1);
        }
        return result;
    }
}