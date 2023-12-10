
class Solution{
    //Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[],int n)
    {
        //O(N)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        int s = 0;
        for(int i = 0; i < n; i++){
            s += arr[i];
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        
        if(map.containsKey(0)) return true;
        
        int key = 0;
        for(int i = 0; i < n; i++){
            key += arr[i];
            map.put(key, map.get(key) - 1);
            if(map.get(key) == 0) map.remove(key); 
            if(map.containsKey(key)) return true;
        }
        
        return false;
    }
}