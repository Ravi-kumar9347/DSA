import java.util.PriorityQueue;

public class Solution {
    public static double MinimiseMaxDistance(int[] arr, int k) {
        int n = arr.length;
        // int[] howmany = new int[n - 1];

        //O(N*K) -> TLE
        //S(N) 
        // for (int i = 1; i <= k; i++) {
        //     double maxVal = -1;
        //     int maxInd = -1;
        //     for (int j = 0; j < n - 1; j++) {
        //         double dist = (double)(arr[j + 1] - arr[j]) /(double) (howmany[j] + 1);
        //         if (dist > maxVal) {
        //             maxVal = dist;
        //             maxInd = j;
        //         }
        //     }
        //     howmany[maxInd]++;
        // }

        // double maxDist = 0;
        // for (int j = 0; j < n - 1; j++) {
        //     double dist = (double)(arr[j + 1] - arr[j]) /(double) (howmany[j] + 1);
        //     if (dist > maxDist) {
        //         maxDist = dist;
        //     }
        // }

        // return maxDist;

        //PriorityQueue
        //O(NLogN)
        //S(N)

        // PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Double.compare(b.sections, a.sections));
        // for(int j = 0; j < n - 1; j++){
        //     pq.add(new Pair(arr[j + 1] - arr[j], j));
        // }

        // for (int i = 1; i <= k; i++) {
        //     Pair p = pq.poll();
        //     int j = p.index;
        //     howmany[j]++;
        //     double dist = (double)(arr[j + 1] - arr[j]) /(double) (howmany[j] + 1);
        //     pq.add(new Pair(dist, j));
        // }
        
        // return pq.peek().sections;


        //BinarySearch
        //O(NLogN)
        //S(1)

        double low = 0, high =0;
        for(int j = 0; j < n - 1; j++){
            high = Math.max(high, (double)arr[j + 1] - arr[j]);
        }

        while(high - low > 1e-6){
            double mid = (low + high) / 2.0;
            int count = howmany(mid, arr);
            if(count > k){
                low = mid;
            } 
            else{
                high = mid;
            }
        }

        return high;
    }

    private static int howmany(double mid, int[] arr){
        int ans = 0;
        for(int j = 0; j < arr.length - 1; j++){
            int distance = (int)((arr[j + 1] - arr[j]) / mid);
            if((arr[j + 1] - arr[j]) == distance * mid){
                distance--;
            }
            ans += distance;
        }

        return ans;
    }
}

class Pair{
    double sections;
    int index;
    Pair(double sections, int index){
        this.sections = sections;
        this.index = index;
    }
}