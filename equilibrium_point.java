
class Solution {

    
    // a: input array
    // n: size of array
    // Function to find equilibrium point in the array.
    public static int equilibriumPoint(long arr[], int n) {
        //O(N)
        //S(1)
        long left = 0, right = 0;
        
        for(long i : arr) right += i;
        
        for(int i = 0; i < n; i++){
            right -= arr[i];
            if(left == right) return i + 1;
            left += arr[i];
        }   
        
        return -1;
    }
}
