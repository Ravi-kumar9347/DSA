class Solution {
    public static Long dp[][];
    public static long minCost(int n, int[] p, int[] f) {
        //O(N * N)
        //S(N * N)
        // code here
        dp=new Long[500][1001];
        return solve(0,0,n,p,f);
        
    }
    public static long solve(int index,int free,int n ,int p[],int f[])
    {
        if(index==n)
        {
            if(free>=0) return 0;
            return (long)1e12;
        }
        if(free+index>=n)
        {
            return 0;
        }
        if(dp[index][500+free]!=null) return dp[index][free+500];
        long max=solve(index+1,free+f[index],n,p,f)+p[index];
        return dp[index][500+free]=Math.min(max,solve(index+1,free-1,n,p,f));
    }
}