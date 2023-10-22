import java.util.ArrayList;
public class Solution
{
    public static int maximumOnesRow(ArrayList<ArrayList<Integer>> matrix, int n, int m)
    {
        //O(NlogM)
        //S(1)
        int val = 0;
        int ind = -1;
        for(int i = 0; i < n; i++){
            int low = 0, high = m - 1;
            while(low <= high){
                int mid = (low + high) / 2;
                if(matrix.get(i).get(mid) == 1){
                    high = mid - 1;
                }
                else{
                    low = mid + 1;
                }
            }
            
            if(val < m - high - 1){
                val = m - high - 1;
                ind = i;
            }
        }

        return ind;
    }
}