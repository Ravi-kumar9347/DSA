class Sol
{
    public static int diffSum(int n,int m,int arr[])
    {
        //O(NlogN)
        //S(1)
        Arrays.sort(arr);
        int i = 0;
        int max = 0, min = 0;
        while(m > 0){
            max += arr[n-i-1];
            min += arr[i];
            i++;
            m--;
        }
        return max - min;
    }
}