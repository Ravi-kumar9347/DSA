class Solution {
    public int numberOfMatches(int n) {
        //O(logN)
        //S(1)
        int totalMathches = 0;
        while(n > 1){
            if(n % 2 == 0){
                totalMathches += (n / 2);
                n /= 2;
            }
            else{
                totalMathches += ((n - 1) / 2);
                n = (n - 1) / 2 + 1;
            }
        }
        return totalMathches;
    }
}