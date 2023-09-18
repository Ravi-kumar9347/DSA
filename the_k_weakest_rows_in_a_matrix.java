class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        //O(N logN)
        //O(2 * N)
        int m = mat.length;
        int n = mat[0].length;

        int[][] rows = new int[m][2]; // Store the number of soldiers and row index

        for (int i = 0; i < m; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += mat[i][j];
            }
            rows[i] = new int[] { count, i };
        }

        Arrays.sort(rows, new Comparator<int[]>() {
            public int compare(int[] row1, int[] row2) {
                if (row1[0] != row2[0]) {
                    return Integer.compare(row1[0], row2[0]);
                } else {
                    return Integer.compare(row1[1], row2[1]);
                }
            }
        });

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = rows[i][1];
        }

        return result;
    }
}