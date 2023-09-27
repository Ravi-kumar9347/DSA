
class Solution{
    // Function for finding maximum and value pair
    public static ArrayList<Integer> printClosest (int arr[], int brr[], int n, int m, int x) {
        //O(N+M)
        //S(1)
        int i = 0, j = m - 1;
        ArrayList<Integer> pair = new ArrayList<>(Arrays.asList(-1, -1));
        int diff =(int)1e9;

        while(i < n && j >= 0){
            int sum = arr[i] + brr[j];
            if(Math.abs(x - sum) < diff){
                pair.set(0, arr[i]);
                pair.set(1, brr[j]);
                diff = Math.abs(x - sum);
            }
            else if(sum < x){
                i++;
            }
            else j--;
        }
        
        return pair;
    }
}