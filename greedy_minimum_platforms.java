class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        //O(NlogN)
        //S(1)
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_needed = 1, result = 1;
        int i = 1, j = 0;
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                plat_needed++;
                i++;
            }
            
            else if(arr[i] > dep[j]){
                plat_needed--;
                j++;
            }
            
            result = Math.max(result, plat_needed);
        }
        
        return result;
    }
    
}