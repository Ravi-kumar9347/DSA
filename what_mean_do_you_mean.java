class Solution{
    public boolean IsMean(int n, int k, int x, int arr[]) {
        // Code Here.
        //O(N)
        //S(N)
        int totalVal = n * x;
        int sum = 0;
        for(int num: arr){
            sum += num;
        }
        int rem = totalVal - sum;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            int v = (arr[i] * k) - arr[i];
            int req = rem - v;
            if(set.contains(req)){
                return true;
            }
            set.add(v);
        }
        return false;
    }
    
}