
class  Solution
{
    void shuffleArray(long arr[], int n)
    {
        //O(n)
        //S(1)
        int x = 10000;
        for(int i = 0; i < n/2; i++){
            arr[i] = arr[i] + arr[(n/2) + i] * x;
        }
        
        int j = n - 1;
        for(int i = (n/2) - 1; i >= 0; i--){
            arr[j] =  arr[i] / x;
            arr[j-1] = arr[i] % x;
            j -= 2;
        }
        
    }
}