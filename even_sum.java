class Solution
{ 
    static int findMin(int A[], int n)
    {
        //O(N(* log2(maximum element in A))
        //S(1)
        int sum = 0;
        boolean even = false;
        
        int result = Integer.MAX_VALUE;
        for(int num : A){
            sum += num;
            if(num % 2 == 0) even = true;
            
            int moves = 0;
            
            while(num != 0 && num % 2 == 0){
                moves++;
                num /= 2;
            }
            
            if(moves != 0) result = Math.min(result, moves);
        }
        
        if(sum % 2 == 0) return 0;
        
        if(even == false) return -1;
        
        return result;
    }
}