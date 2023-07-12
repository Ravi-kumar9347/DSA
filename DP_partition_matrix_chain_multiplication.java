import java.util.*;
import java.io.*;

public class Solution {

	// O(N * N * N) ~~ O(N^3)
	// S(N * N) + O(N)
	private static int fun(int i, int j, int[] arr, int[][] dp) {
		if (i == j)
			return 0;
		if (dp[i][j] != -1)
			return dp[i][j];
		int mini = (int) (1e9);
		for (int k = i; k < j; k++) {
			int steps = arr[i - 1] * arr[k] * arr[j] + fun(i, k, arr, dp) + fun(k + 1, j, arr, dp);
			mini = Math.min(mini, steps);
		}
		return dp[i][j] = mini;
	}

	public static int matrixMultiplication(int[] arr, int N) {
		// recursion -> O(exponential)

		int[][] dp = new int[N][N];
		// for(int[] row : dp){
		// Arrays.fill(row, -1);
		// }

		// return fun(1, N - 1, arr, dp);

		for (int i = N - 1; i >= 1; i--) {
			for (int j = i + 1; j < N; j++) {
				int mini = (int) (1e9);
				for (int k = i; k < j; k++) {
					int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k + 1][j];
					mini = Math.min(mini, steps);
				}
				dp[i][j] = mini;
			}
		}
		return dp[1][N - 1];
	}
}
