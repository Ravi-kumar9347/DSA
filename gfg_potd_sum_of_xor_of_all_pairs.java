class Solution{
   
    // Function for finding maximum and value pair
    public long sumXOR (int arr[], int n) {
        //O(N)
        //S(1)
        long result = 0;
        for (int i = 0; i < 31; i++) { // Iterate through each bit position (0 to 30)
            int countZeroes = 0; // Count of 0s at the current bit position
            int countOnes = 0;  // Count of 1s at the current bit position
            
            // Count the number of elements with 0 and 1 at the current bit position
            for (int j = 0; j < n; j++) {
                if ((arr[j] & (1 << i)) == 0) {
                    countZeroes++;
                } else {
                    countOnes++;
                }
            }
            
            // Calculate the XOR contribution for the current bit position
            long bitXOR = (long)countZeroes * countOnes * (1 << i);
            result += bitXOR;
        }
        
        return result;
    }
    
    
}