// public class Solution {
//     public static int setBits(int N){
//         int i = 0;
//         int a = N;
//         while(a != 0){
//             int bit = N & (1 << i);
//             if(bit == 0){
//                 N = N | (1 << i);
//                 return N;
//             }
//             a = a >> 1;
//             i++;
//         }
//         return N;
//     }
// }

/*
   Time Complexity : O(1)
   Space Complexity : O(1)
*/
public class Solution {
    public static int setBits(int N){
        // Check if there's any unset bits.
        if((N & (N+1)) == 0)
            return N;

        // Set the least significant unset bit of 'N' to 1 and return.
        return N | (N+1);
    }
}
