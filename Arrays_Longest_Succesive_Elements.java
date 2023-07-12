import java.util.*;
public class Solution {
    public static int longestSuccessiveElements(int []a) {
        //O(N) S(N)
        Set<Integer> hashSet = new HashSet<Integer>();
        for(int num:a){
            hashSet.add(num);
        }

        int longestStreak = 0;
        for(int num:a){
            if( !hashSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(hashSet.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}