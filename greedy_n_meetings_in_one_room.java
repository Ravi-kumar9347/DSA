
class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        //O(nlogn)
        //S(1)
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            arr[i][0] = start[i];
            arr[i][1] = end[i];
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        
        int endTime = -1;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(endTime < arr[i][0]){
                count++;
                endTime = arr[i][1];
            }
        }
        
        return count;
    }
}