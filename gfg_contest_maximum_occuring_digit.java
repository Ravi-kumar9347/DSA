class Solution{
    static int maxoccourence(int[] arr,int n,int k){
        //O(N)
        //S(1)
        int mini = (int)1e9, c = 0;
        for(int i = 0; i < n; i++){
            int num = arr[i], cur = 0;
            while(num > 0){
                int rem = num % 10;
                if(rem == k){
                    cur++;
                }
                num = num / 10;
            }
            if(cur == c){
                mini = Math.min(mini, arr[i]);
            }
            else if(cur > c){
                c = cur;
                mini = arr[i];
            }
        }
        
        return mini == (int)1e9 ? -1 : mini;
    }
    
}