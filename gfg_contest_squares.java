class Solution 
{ 
    int squares(int N, int X) 
    { 
        //O(logN)
        //S(1)
        long side = 1 << N; 
        long totalSquares = side * side;
        
        if(X > totalSquares) return -1;
        
        X--;
        long ans = X / 3;
        if((X % 3) != 0) ans ++;
        
        return (int)ans;
    }
} 