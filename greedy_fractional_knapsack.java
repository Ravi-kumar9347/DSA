class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        //O(NlogN)
        //S(1)
        Arrays.sort(arr, (a, b) -> Double.compare((double) b.value / b.weight, (double) a.value / a.weight));
        double ans = 0.0;

        for(int i = 0; i < arr.length; i++){
            Item item = arr[i];
            int val = item.value, wei = item.weight;
            if(wei <= W){
                ans += val;
                W -= wei;
            }
            else{
                ans += (double)(W * val) / wei;
                break;
            }
        }
        
        return ans;
    }
}