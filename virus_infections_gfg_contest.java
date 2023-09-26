class Solution 
{ 
    int solve(String s, int k) 
    { 
        //O(N)
        //S(N)
        int n = s.length(), ans = 0, last = -1;
        int[] vis = new int[n];
        //for right side 
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '1'){
                vis[i] = 1;
                ans++;
                last = i;
            }
            else if(last != -1 && i - last <= k){
                vis[i] = 1;
                ans++;
            }
        }
        //for left side
        last = -1;
        for(int i = n - 1; i >= 0; i--){
            if(s.charAt(i) == '1'){
                last = i;
            }
            else if(last != -1 && last - i <= k && vis[i] == 0){
                vis[i] = 1;
                ans++;
            }
        }
        
        return ans;
    }
}