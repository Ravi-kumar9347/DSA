import java.util.ArrayList;

public class Solution 
{
     private static int split(long largestSum, ArrayList<Integer> boards){
        int count = 0, currentSum = 0;
        for(int i = 0; i < boards.size(); i++){
            if(currentSum + boards.get(i) <= largestSum){
                currentSum += boards.get(i);
            }
            else{
                count++;
                currentSum = boards.get(i);
            }
        }
        count++;
        return count;
    }
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //O(N * log(sum(nums) - max(nums)))
        //S(1)
        long low = -1, high = 0;
        
        for(int i = 0; i < boards.size(); i++){
            low = Math.max(low, boards.get(i));
            high += boards.get(i);
        }

        while(low <= high){
            long mid = (low + high) / 2;
            if(split(mid, boards) <= k){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return (int)low;
    }
}