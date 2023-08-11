class Solution {
    public int uniquePaths(int m, int n) {
        
        //O(m-1) || O(n-1) depends on selecting the value of r
        //S(1) 
        int N=m+n-2;
        int r=n-1;//r=m-1 ->we can select anyone
        double res=1;
        for(int i=1;i<=r;i++){
            res= res*(N-r+i)/i;
        }
        return (int)res;

        
    }
}

class Solution {
    public int uniquePaths(int m, int n) {
        //O(N*M)
        //O(N)
        int[] prev = new int[n];
        Arrays.fill(prev, 1);

        for(int i = m - 2; i >= 0; i--){
            int[] cur = new int[n];
            cur[n - 1] = 1;
            for(int j = n - 2; j >= 0; j--){
                cur[j] = prev[j] + cur[j + 1];
            }
            prev = cur;
        }
        return prev[0];
    }
}