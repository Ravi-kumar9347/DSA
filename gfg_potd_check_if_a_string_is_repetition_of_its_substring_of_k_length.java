
class Solution
{
    int kSubstrConcat(int n, String s, int k)
    {
        //O(N)
        //S(n)
        if(n % k != 0) return 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < n; i = i + k){
            String sub = s.substring(i, i + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        
        return map.size() > 2 ? 0 : 1;
        
//         // check if n is equal to k, then return 1
//         if (n == k) return 1;
        
//         // check if n is not divisible by k, then return 0
// 		if (n % k != 0) return 0;
		
// 		// create a HashMap to store substrings and their frequencies
// 		HashMap <String, Integer> m=new HashMap<>();
		
// 		// iterate over the string in increments of k
// 		for (int i = 0; i < n; i += k)
// 		{
// 			// store substring from i to i+k in HashMap with its frequency
// 			m.put(s.substring (i, i+k),m.getOrDefault(s.substring(i,i+k),0)+1);
// 		}

// 		// check if there is only one unique substring, then return 1
// 		if (m.size () == 1) return 1;
		
// 		// check if there are not exactly two unique substrings, then return 0
// 		if (m.size () != 2) return 0;

//         int val=0;
//         // get the frequency value of one substring
//         for(int i:m.values()){
//             val=i;
//             break;
//         }
        
// 		// check if the frequency value is equal to (n/k - 1) or 1, then return 1
// 		if ((val == (n / k - 1)) || (val == 1))
// 			return 1;
		
// 		// return 0 if none of the above conditions are satisfied
// 		return 0;
    }
}