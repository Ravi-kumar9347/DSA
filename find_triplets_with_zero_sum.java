class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //time complexity is O(n^2) and the space complexity is O(n).
        Map<Integer, List<Integer>> hashMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int number = arr[i];
            
            if (hashMap.containsKey(number)) {
                List<Integer> indices = hashMap.get(number);
                indices.add(i);
            } else {
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                hashMap.put(number, indices);
            }
        }

        for(int i = 0; i < n; i++){
            int sum = arr[i];
            for(int j = i + 1; j < n; j++){
                sum += arr[j];
                int remaining = 0 - sum;
                
                if (hashMap.containsKey(remaining)) {
                    List<Integer> indices = hashMap.get(remaining);
                    for (int index : indices) {
                        if(index != i && index != j){
                            return true;
                        }
                    }
                }
                else{
                    sum -= arr[j];
                }
            }
        }
        return false;
    }
}