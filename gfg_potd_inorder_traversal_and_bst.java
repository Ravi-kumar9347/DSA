
class Solution
{
    static int isRepresentingBST(int arr[], int N)
    {
        //O(N)
        //S(1)
        for(int i = 1; i < N; i++){
            if(arr[i-1] >= arr[i]) return 0;
        }
        return 1;
    }
}