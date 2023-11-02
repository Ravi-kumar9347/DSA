class Solution {
    int minDist(int a[], int n, int x, int y) {
        // O(N)
        // S(1)
        int dist = (int)1e9;
        int xdist = 0, ydist = 0;
        boolean x1 = false, y1 = false;
        for(int i = 0; i < n; i++){
            if(a[i] == x){
                xdist = i;
                x1 = true;
            }
            else if(a[i] == y){
                ydist = i;
                y1 = true;
            }
            
            if(x1 == true && y1 == true) dist = Math.min(dist, Math.abs(xdist - ydist));
        }
        
        return dist == (int)1e9 ? -1 : dist;
    }
}