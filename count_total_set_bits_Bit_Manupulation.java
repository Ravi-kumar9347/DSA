
class Solution{
    
    //Function to return sum of count of set bits in the integers from 1 to n.
    public static int countSetBits(int n){
        //O(log(N)) ~ O(30)
        long ans = 0; // Change data type to long
        n++;
        for (int i = 0; i < 32; i++) {
            long groupSize = (1L << (i + 1)); // Change data type to long
            long noOfGroups = n / groupSize; // Change data type to long
            long noOfBits = (1L << i); // Change data type to long
            ans += (noOfBits * noOfGroups);

            if (i < 31) {
                long remainingBits = n % groupSize; // Change data type to long
                long remainingSetBits = Math.max(0, remainingBits - noOfBits); // Change data type to long
                ans += remainingSetBits;
            }
        }

        return (int) ans; // Convert the result back to int before returning
    }
}