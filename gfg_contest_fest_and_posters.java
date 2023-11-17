
class Solution {
    public static long minimumTime(int N,int NUM,int time[])
    {
        //O(N*log1e14)
        //S(1)
        long low = 1, high = (long)1e14;
        while(low <= high){
            long mid = (low + high) / 2;
            // System.out.println(mid);
            
            if(isPossible(mid, time) >= NUM){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
    
    private static long isPossible(long t, int[] time){
        long ans = 0;
        for(int num : time){
            ans += (t / num);
        }
        return ans;
    }
} 