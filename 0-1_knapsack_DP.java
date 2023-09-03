import java.util.*;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        //O(N*maxWeight)
        //S(maxWeight)
        int[] prev = new int[maxWeight+1];
              
        for(int i = n - 1; i >= 0; i--){
            int[] cur = new int[maxWeight+1];
            for(int j = maxWeight; j >= 0; j--){
                int notTake = prev[j];
                int take = 0;
                if(j + weight[i] <= maxWeight){
                    take = value[i] + prev[j + weight[i]];
                }
                cur[j] = Math.max(notTake, take);
            }
            prev = cur;
        }
        return prev[0];
    }
}
