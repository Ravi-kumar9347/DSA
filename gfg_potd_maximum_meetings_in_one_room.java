class Solution {
    public static ArrayList<Integer> maxMeetings(int n, int[] s, int[] f) {
        //O(NlogN)
        //S(N)
        int[][] arr = new int[n][3];
        for(int i = 0; i < n; i++){
            arr[i][0] = s[i];
            arr[i][1] = f[i];
            arr[i][2] = i + 1;
        }
        
        Arrays.sort(arr, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        ArrayList<Integer> result = new ArrayList<>();
        int fin = -1;
        
        for(int i = 0; i < n; i++){
            if(fin < arr[i][0]){
                fin = arr[i][1];
                result.add(arr[i][2]);
            }
        }
        
        Collections.sort(result);
        
        return result;
    }
}