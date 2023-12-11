class Solution{
    static long maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
        //O(N)
        //S(1)
        long sum = 0;
        for(int i = 0; i < K; i++){
            sum += Arr.get(i);
        }
        
        long result = 0;
        for(int i = K; i < N; i++){
            result = Math.max(result, sum);
            sum -= Arr.get(i-K);
            sum += Arr.get(i);
        }
        
        result = Math.max(result, sum);
        return result;
    }
}