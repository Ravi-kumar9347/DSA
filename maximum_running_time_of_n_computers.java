class Solution {
    public long maxRunTime(int n, int[] batteries) {
        //binary search O(N logN) + O(N) + O(N)
        //s(1)
        // long stTime=0;
        // long edTime=0;
        // for(int i=0;i<batteries.length;i++){
        //     edTime+=batteries[i];
        // }
        // long ans=0;
        // while(stTime<=edTime){
        //     long mid=stTime + (edTime-stTime)/2;
        //     if(isPossible(n,batteries,mid)){
        //         ans=mid;
        //         stTime=mid+1;
        //     } else {
        //         edTime=mid-1;
        //     }
        // }
        // return ans;
        

        //Greedy O(N logN) + O(N) + O(N)
        long total_time = 0; // Variable to store the total time of all batteries
        for (int x : batteries) total_time += x; // Calculate the total time by summing all battery times
        
        Arrays.sort(batteries); // Sort the battery times in ascending order
        
        // Loop through the sorted battery times and try to optimize the run time
        for (int i = batteries.length - 1; i >= 0; i--, n--) {
            // If the current battery time is less than or equal to the average time (total_time/n),
            // then it won't be a bottleneck, so we can stop optimizing further
            if (batteries[i] <= (total_time / n)) break;
            
            total_time -= batteries[i]; // Reduce the total time by the current battery time
        }
        
        return total_time / n; // Return the optimized maximum run time
    }
    public boolean isPossible(int n,int batteries[],long mid){
        long time=0;
        for(int i=0;i<batteries.length;i++){
            if(batteries[i]<=mid){
                time+=batteries[i];
            } else {
                time+=mid;
            }
        }
        return time>= mid*n;
    }
}