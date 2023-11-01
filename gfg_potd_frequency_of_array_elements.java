class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int n, int p)
    {
        //O(N)
        //S(1)
        int i = 0;
        
        while(i < n){
            if(arr[i] <= 0 || arr[i] > n || arr[i] > p){
                i++;
                continue;
            } 
            int num = arr[i] - 1;
            if(arr[num] > 0){
                arr[i] = arr[num];
                arr[num] = -1;
            }
            else{
                arr[i] = 0;
                arr[num] -= 1;
                i++;
            }
        }
        for( i = 0; i < n; i++){
            if(arr[i] < 0){
                arr[i] = -1 * arr[i];
            }
            else{
                arr[i] = 0;
            }
        }
    }
}
