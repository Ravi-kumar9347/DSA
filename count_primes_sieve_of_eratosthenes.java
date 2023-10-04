class Solution {
    public int countPrimes(int n) {
        // O(Nlog(logN))
        // S(N)
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        int count = 0;

        for(int i = 2; i < n; i++){
            if(isPrime[i]){
                count++;
                for(int j = i; j <= n; j+=i){
                    isPrime[j] = false;
                } 
            }
        }

        return count;
    }
}