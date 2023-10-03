class Solution {
    public int minBitFlips(int start, int goal) {
        //O(32)
        int result = 0;
        for(int i = 0; i < 31; i++){
            if((start & (1 << i)) != (goal & (1 << i))) result++;
        }
        return result;
    }
}

// class Solution {
//     public int minBitFlips(int start, int goal) {
//         int a = (start ^ goal);
//         int count = 0;
        
//         while(a != 0) {
//             if((a & 1) == 1) {
//                 count++;
//             }
            
//             a = a >> 1;
//         }
        
//         return count;
//     }
// }