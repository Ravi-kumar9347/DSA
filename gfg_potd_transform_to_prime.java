
class Solution
{
    public static boolean isPrime(int n) {
        // Corner case
        if (n <= 1)
            return false;

        // Check from 2 to square root of n
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0)
                return false;

        return true;
    }

    public int minNumber(int arr[], int N)
    {
        //O(N) + O(sqrt(sum))
        //S(1)
        int sum = 0;
        for(int i : arr) sum += i;
        int sum1 = sum;
        
        while (sum < (int)1e6+10) {
            if (isPrime(sum)) {
                return sum - sum1;
            }
            sum++;
        }
        
        return -1;
    }
}