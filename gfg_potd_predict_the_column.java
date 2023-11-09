class Solution
{
    int columnWithMaxZeros(int arr[][], int N)
    {
        //O(N*N)
        //S(1)
        int maxVal = 0, maxInd = -1;
        for(int i = 0; i < N; i++){
            int c = 0;
            for(int j = 0; j < N; j++){
                if(arr[j][i] == 0) c++;
            }
            if(maxVal < c){
                maxVal = c;
                maxInd = i;
            }
        }
        return maxInd;
    }
} 