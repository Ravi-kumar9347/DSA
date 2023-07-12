class Solution
{
    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // HashSet<Integer> hashSet = new HashSet<>();
        // int small = 1;
        // for(int i = 0; i < size; i++){
        //     if(arr[i] > 0 && arr[i] == small){
        //         small += 1;
        //         while(hashSet.contains(small)){
        //             small += 1;
        //         }
        //     }
        //     if(arr[i] > 0) hashSet.add(arr[i]);
        // }
        // return small;
        
        //O(N) S(1)
        
       for (int i = 0; i < size; i++) {
            while (arr[i] > 0 && arr[i] < size + 1 && arr[i] != arr[arr[i] - 1]) {
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }

        for (int i = 0; i < size; i++) {
            if (i + 1 != arr[i]) {
                return i + 1;
            }
        }
        
        return size + 1;

    }
}
