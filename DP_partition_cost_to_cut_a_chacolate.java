import java.util.*;
import java.io.*;

public class Solution {
    static int fun(int i, int j, int[] cut, int[][] dp) {
        if (i > j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = cut[j + 1] - cut[i - 1] + fun(i, k - 1, cut, dp) + fun(k + 1, j, cut, dp);
            mini = Math.min(mini, cost);
        }
        return mini;
    }

    public static int cost(int n, int c, int cuts[]) {
        int[] cut = new int[c + 2];
        cut[0] = 0;
        int i = 0;
        for (i = 0; i < c; i++) {
            cut[i + 1] = cuts[i];
        }
        cut[c + 1] = n;
        Arrays.sort(cut);
        int[][] dp = new int[c + 2][c + 2];
        // for(int[] row: dp) Arrays.fill(row, -1);

        // return fun(1, c, cut, dp);
        //O(C * C) //S(C*C) + S(C)
        for (i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {
                if (i > j)
                    continue;
                int mini = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = cut[j + 1] - cut[i - 1] + dp[i][k-1]+ dp[k+1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][c];
    }

}