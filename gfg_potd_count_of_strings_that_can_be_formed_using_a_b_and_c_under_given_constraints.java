class Solution 
{ 
    static long countStr(long n)
	{
	    //O(1)
	    //S(1)
	    return 1 + n + n + n * (n - 1) + n * (n - 1) / 2 + n * (n - 1) * (n - 2) / 2; 
	}
} 