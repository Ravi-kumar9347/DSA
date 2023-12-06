class Solution {
    int countX(int L, int R, int X) {
        //O(R-l * logR)
        int count = 0;
        for(int i = L + 1; i < R; i++){
            int num = i;
            while(num > 0){
                int rem = num % 10;
                if(rem == X) count++;
                num /= 10;
            }
        }
        return count;
    }
};