class Solution {
    static int setBits(int N) {
        int numberOfBits = 0;
        while(N > 0){
            if(N % 2 == 1) numberOfBits++;
            N /= 2;
        }
        return numberOfBits;
    }
}