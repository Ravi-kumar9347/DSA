import java.util.List;
import java.util.*;
public class Solution {
    public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
        int n = arr.length;
        //O(N*N)
        //S(N)
        int[] data = new int[n];
        int[] vis = new int[n];
        
        Arrays.fill(data, 1);
        for(int i = 0; i < n; i++) vis[i] = i;
        
        int maxLis = 1;
        int lisInd = 0;
        
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(arr[j] > arr[i] && data[j] <= data[i]){
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

// import java.util.List;
// import java.util.ArrayList;

// public class Solution {
//     public static List< Integer > printingLongestIncreasingSubsequence(int []arr, int x) {
//         int[][] dp = new int[x+1][x+1];

//         for(int i = x - 1; i >= 0; i--){
//             for(int j = i - 1; j >= -1; j--){
//                 int notTake = dp[i + 1][j + 1];
//                 int take = 0;
//                 if(j == -1 || arr[i] > arr[j]){
//                     take = 1 + dp[i + 1][i  + 1];
//                 }
//                 dp[i][j + 1] = Math.max(notTake, take);
//             }
//         }   
//         int i = 0, j = 0;
//         List<Integer> lis = new ArrayList<Integer>();
//         while(i < x && j < x){
//             if(dp[i][j] == 1 + dp[i + 1][j + 1]){
//                 lis.add(arr[i]);
//                 i = i + 1;
//                 j = j + 1;
//             }
//             else{
//                 i++;
//             }
//         }
//         return lis;
//     }
// }