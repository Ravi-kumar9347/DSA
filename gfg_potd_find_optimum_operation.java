class Solution
{
    public int minOperation(int n)
    {
        //O(logN)
        //S(1)
        int count = 0;
        while(n > 1){
            count++;
            if(n % 2 == 1){
                count++;
            }
            n /= 2;
        }
        return count + 1;
    }
}