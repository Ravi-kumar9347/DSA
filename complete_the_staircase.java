class Solution {
    public int completeRows(int n) {
        //O(sqrt(N))
        int num = 1, cnt = 1;
 
        while(num <= n){
            num += cnt + 1;
            cnt++;
        }
        return cnt - 1;
    }
}