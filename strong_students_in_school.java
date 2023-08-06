class Solution
{
    public static int diffSum(int n,int m,int arr[])
    {
        //O(NlogN)
        //S(1)
        Arrays.sort(arr);
        int i = 0, j = n - 1;
        int minSum = 0, maxSum = 0;
        while(i < m && j >= n - m){
            minSum += arr[i++];
            maxSum += arr[j--];
        }
        
        return maxSum - minSum;
    }
}