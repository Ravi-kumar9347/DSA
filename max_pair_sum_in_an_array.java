class Solution {
    public int maxSum(int[] nums) {
    //O(N) + O(KlogK)(sorting)
    //S(N)
    int ans = -1;
    Map<Integer,List<Integer>> ump = new HashMap<>();
    for(int i = 0; i < nums.length; ++i){
        int t = nums[i], maxDigit = 0;
        while(t != 0){ //evaluate max digit in the number
            maxDigit = Math.max(t%10, maxDigit);
            t = t/10;
        }
        if(!ump.containsKey(maxDigit)) ump.put(maxDigit, new ArrayList<>());
        ump.get(maxDigit).add(nums[i]); // add the number to the map 
    }
    for(Map.Entry<Integer, List<Integer>> entry: ump.entrySet()){
        entry.getValue().sort(Comparator.reverseOrder()); //to find max two number in each max digit 
        if(entry.getValue().size() >= 2) ans = Math.max(ans, entry.getValue().get(0) + entry.getValue().get(1)); //sum max two number and take max
    }
    return ans;
}
}