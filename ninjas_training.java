import java.util.Arrays;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {
        //O(N * 3 * 3)
        //S(1)
        int[] prev = new int[3];
        for(int i = 0; i < 3; i++) prev[i] = points[n-1][i];

        for(int i = n - 2; i >= 0; i--){
            int[] cur = new int[3];
            for(int j = 2; j >= 0; j--){
                int maxi = 0;
                for(int k = 2; k >= 0; k--){
                    if(j != k) maxi = Math.max(maxi, prev[k]);
                }
                cur[j] = points[i][j] + maxi;
            }
            prev = cur;
        }
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }

    
}
