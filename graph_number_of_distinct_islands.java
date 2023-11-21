import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;

public class Solution 
{
	public static int distinctIsland(int [][] arr, int n, int m) 
	{
		int[][] vis = new int[n][m];
		HashSet<List<String>> set = new HashSet<>();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(vis[i][j] == 0 && arr[i][j] == 1){
					List<String> temp = new ArrayList<>();
					dfs(i, j, i, j, vis, arr, temp);
					set.add(temp);
				}
			}
		}
		return set.size();
	}

	private static String toString(int r, int c){
		return Integer.toString(r) + " " + Integer.toString(c);
	}

	private static void dfs(int row, int col, int baseRow, int baseCol, int[][] vis, int[][] arr, List<String> temp){
		vis[row][col] = 1;
		temp.add(toString(row - baseRow, col - baseCol));
		int n = arr.length;
		int m = arr[0].length;
		int[] dr = {-1, 0, 1, 0};
		int[] dc = {0, 1, 0, -1};
		for(int i = 0; i < 4; i++){
			int nrow = row + dr[i], ncol = col + dc[i];
			if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && arr[nrow][ncol] == 1){
				dfs(nrow, ncol, baseRow, baseCol, vis, arr, temp);
			}
		}
	}
}
