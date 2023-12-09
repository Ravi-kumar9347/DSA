class Solution {
    
    static int sumofdigit(int n)
    {
        int curr = n , sums=0;
        while(curr > 0)
        {
            sums += curr % 10;
            curr /= 10;
        }
        return sums;
    }    
    
    static int smithNum(int n) 
    {
        //O(nlogN)
        //S(1)
        int sum=0,curr=sumofdigit(n),res=n;
        for(int i=2;i*i<=n;i++)
        {
            while(n % i == 0)
            {
                sum += sumofdigit(i);
                n /= i;
            }
        }
        if(n > 1)
        {
            sum+=sumofdigit(n);
        }
        if(res == n)
        {
            return 0;
        }
        if(curr == sum)
        {
            return 1;
        }
        return 0;
    }
}
