class Solution {
    public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        //O(N)
        //S(1)
        for(int i = 0; i < n; i++){
            int num = arr[i];
            int cnt = 0;
            while(i < n && arr[i] == num){
                cnt++;
                i++;
            }

            if(((double)cnt / (double)n) > 0.25) return num;
            // System.out.println((double)cnt / (double)n);
            i--;
        }

        return -1;
    }
}