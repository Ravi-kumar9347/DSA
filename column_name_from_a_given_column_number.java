class Solution
{
    String colName (long n)
    {
        // your code here
        //O(logN)
        //S(1)
        StringBuilder s = new StringBuilder();
        
        while(n > 0){
            if(n % 26 == 0){
                s.insert(0, (char)(((n - 1) % 26) + 65));
                n = (n - 1) / 26;
            }
            else{
                s.insert(0, (char)((n % 26) + 64));
                n /= 26;
            }
        }
        
        return s.toString();
    }
}