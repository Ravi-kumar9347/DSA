class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        ArrayList<Integer> result = new ArrayList<Integer>();
        int right = arr[n - 1]; 
        result.add(right);
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] >= right){
                right = arr[i];
                result.add(0,right);
            }
        }
        return result;
    }
}
