
class Solution 
{
    //Function to find all elements in array that appear more than n/k times.
    public int countOccurence(int[] arr, int n, int k) 
    {
        //O(N)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int c = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int val = entry.getValue();
            if(val > n / k){
                c++;
            }
        }
        
        return c;
    }
}
