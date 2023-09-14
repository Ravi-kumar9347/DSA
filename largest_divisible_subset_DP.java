class Solution {
    public List<Integer> largestDivisibleSubset(int[] arr) {
        //O(N*N)
        //S(N)
        int n = arr.length;
        int[] data = new int[n];
        int[] vis = new int[n];
        
        Arrays.fill(data, 1);
        for(int i = 0; i < n; i++) vis[i] = i;
        Arrays.sort(arr);

        int maxLis = 1;
        int lisInd = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[j] % arr[i] == 0 && data[j] <= data[i]){
                    data[j] = data[i] + 1;
                    vis[j] = i;
                    if(maxLis < data[j]){
                        maxLis = data[j];
                        lisInd = j;
                    }
                } 
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(vis[lisInd] != lisInd){
            result.add(arr[lisInd]);
            lisInd = vis[lisInd];
        }
        result.add(arr[lisInd]);
        
        Collections.sort(result);
        
        return result;
    }
}