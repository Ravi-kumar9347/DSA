import java.util.List;
import java.util.*;
public class Solution {
    public static List< Integer > countPrimes(int n) {
        //O(Nlog(logN))
        //S(N)
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        List< Integer > ans = new ArrayList<>();

        for(int i = 2; i < n; i++){
            if(isPrime[i] && n % i == 0){
                ans.add(i);
                for(int j = i; j <= n; j+=i){
                    isPrime[j] = false;
                } 
            }
        }

        return ans;
    }
}
