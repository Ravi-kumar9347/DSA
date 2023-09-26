class Solution 
{ 
    String construct(int N, int K) 
    { 
        //O(N) S(1)
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < N; i++){
            if(i % 2 == 0) str.append('r');
            else str.append('a');
        }
        
        return str.toString();
    }
} 