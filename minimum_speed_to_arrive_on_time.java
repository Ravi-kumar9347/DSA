class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = (int) 1e7;

        // Binary search to find the minimum speed
        while (low < high) {
            int mid = low + (high - low) / 2;
            double time = calculateTotalTime(dist, mid);
            
            if (time > hour) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        // Check if the minimum speed satisfies the condition
        double totalTime = calculateTotalTime(dist, low);
        return totalTime <= hour ? low : -1;
    }

    private double calculateTotalTime(int[] dist, int speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil(dist[i] / (double) speed);
        }
        time += dist[dist.length - 1] / (double) speed;
        return time;
    }
}
