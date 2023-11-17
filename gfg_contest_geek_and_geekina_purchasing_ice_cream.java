class Solution{
    static long findGoodPairs(int a[], int n, int k){
        //O(N)
        //S(N)
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int[] val = new int[n];
        for(int i = 0; i < n; i++){
            if(!map.containsKey(a[i])){
                List<Integer> temp = new ArrayList<>();
                temp.add(i);
                map.put(a[i], temp);
            }
            else{
                List<Integer> temp = map.get(a[i]);
                for(int j = temp.size() - 1; j >= 0; j--){
                    if(i - temp.get(j) >= k){
                        if(val[j] == 0) val[i] = val[j] + 1 + j;
                        else val[i] = val[j] + 1;
                        break;
                    }
                    else{
                        val[i] = val[j];
                    }
                }
                temp.add(i);
                map.put(a[i], temp);
            }
        }
        
        long ans = 0;
        for(int i = 0; i < n; i++) ans += val[i];
        return ans;
    }
 
}

// class Solution{
//     static long findGoodPairs(int a[], int n, int k){
//         // Code your solution here.
//         long ans = 0;
//         Map<Integer, Integer> hm = new HashMap<>();
//         for(int i = k; i < n; i++){
//             hm.put(a[i - k], hm.getOrDefault(a[i - k], 0) + 1);
//             ans += hm.getOrDefault(a[i], 0);
//         }
//         return ans;
//     }
// }