class Solution {
    static int maxBoxes(int N, int K, int C, int col[]) {
        //O(N * N)
        //S(1)
        int left = 0, right = 0, sum = 0, ans = 0, count = 0;
        
        for(int i = 0; i < N - 1; i++){
            if(col[i] == col[i + 1] && col[i] == C){
                sum = 2;
                
                left = i - 1;
                right = i + 2;
                
                while(left >= 0 && right < N && col[left] == col[right]){
                    count = 2;
                    left--;
                    right++;
                    
                    if(left >= 0 && col[left] == col[left + 1]){
                        count++;
                        left--;
                    }
                    
                    if(right < N && col[right] == col[right - 1]){
                        count++;
                        right++;
                    }
                    
                    if(count >= 3){
                        sum += count;
                    }
                    else{
                        break;
                    }
                }
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}