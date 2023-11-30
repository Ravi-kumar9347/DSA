import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
public class Solution {
    public static int minimumOperations(int n, int start, int end, int []a) {
        //O(N*1000)
        //S(1000)
        if(start == end) return 0;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        int[] dist = new int[1000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        int mod = 1000;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curnum = cur[0], curSteps = cur[1];
            for(int i = 0; i < n; i++){
                int nextNum = (curnum * a[i]) % mod;
                if(nextNum == end){
                    return curSteps+1;
                }
                if(curSteps + 1 < dist[nextNum]){
                    dist[nextNum] = curSteps + 1;
                    q.add(new int[]{nextNum, curSteps+1});
                }
            }
        }
        return -1;
    }
}