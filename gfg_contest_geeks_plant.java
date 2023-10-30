class Solution{
    public long minimumBuckets(int n, int arr[]){
        //O(N * log(min(a, b)))
        //S(1)
        int gcd = arr[0];
        for(int i = 1; i < n; i++){
            gcd = fun(gcd, arr[i]);
        }
        
        long ans = 0;
        for(int i = 0; i < n; i++){
            ans += (arr[i] / gcd);
        }
        
        return ans;
    }
    
    static int fun(int a, int b){
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}