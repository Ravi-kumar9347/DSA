class Solution{
    static int findWinner(int n, int A[]){
        //O(N)
        //S(1)
        if(n % 2 == 0) return 1;
        int val = 0;
        for(int num : A) val ^= num;
        
        if(val == 0) return 1;
        return 2;
    }
}