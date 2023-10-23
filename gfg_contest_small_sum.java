class Solution{
    
    //Function to find the smallSum value of the array
    public static int smallSum(int [] arr, int K){
        //S(N)
        //O(1)
        int n = arr.length;
        int mod = (int)1e9+7;
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] < arr[(i + 1) % n]){
                sum = (sum + arr[i]) % mod;
            }
            else{
                sum = (sum + (arr[i] % K)) % mod;
            }
        }
        return sum;
    }
}