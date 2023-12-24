class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
        //O(nlogn)
        //S(n)
        long[] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = price[i] * 100000 + (i + 1); 
        }
        
        Arrays.sort(arr);
        int c = 0;
        for(int i = 0; i < n; i++){
            int pr = (int)arr[i] / 100000;
            int day = (int)arr[i] % 100000;
            
            if(k >= pr*day){
                c += day;
                k -= (pr * day);
            }
            else{
                c += (k /pr);
                k -= (k /pr) * pr;
            }
        }
        
        return c;
    }
}