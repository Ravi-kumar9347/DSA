class Solution{
    public long MaxXP(int n, int k, int initial_exp, int exp_req[], int exp_gain[]) {
        // O(N logN)
        //S(N) + S(K) ~ S(N)
        int[][] arr = new int[n][2];
        long xp = initial_exp;
        for (int i = 0; i < n; i++)
        {
            arr[i][0] = exp_req[i];
            arr[i][1] = exp_gain[i];
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int i = 0;
        while (k-- > 0)
        {
            while (i < n && arr[i][0] <= xp)
                pq.add(arr[i++][1]);
            if (pq.isEmpty())
                return xp;
            xp += pq.poll();
        }

        return xp;
    }
}