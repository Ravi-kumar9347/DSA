import java.util.* ;
import java.io.*; 
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){

        //O(N * K)
        //S(K)
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        
        for(int i = n - 1; i >= 0; i--){
            boolean[] cur = new boolean[k+1];
            for(int j = 0; j <= k; j++){
                boolean notTake = false, take = false;
                notTake = prev[j];
                if(j - arr[i] >= 0 && j - arr[i] <= k){
                    take = prev[j - arr[i]];
                }
                cur[j] = notTake || take;
            }
            prev = cur;
        }
        
        return prev[k];
    }
}
