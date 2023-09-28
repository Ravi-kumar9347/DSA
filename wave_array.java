class Solution {
    //O(N)
    //S(1)
    private static void swap(int i, int j, int[] a){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
    public static void convertToWave(int n, int[] a) {
        for(int i = 0; i < n - 1; i++){
            if(i % 2 == 0 && a[i] < a[i + 1]) swap(i, i + 1, a);
            else if(i % 2 == 1 && a[i] > a[i + 1]) swap(i, i + 1, a);
        }
    }
}