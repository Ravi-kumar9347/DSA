class Solution {
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        //O(1)
        //S(1)
        int xdiff = Math.abs(fx - sx), ydiff = Math.abs(fy - sy);
        if(xdiff == 0 && ydiff == 0 && t == 1) return false;
        return Math.min(xdiff, ydiff) + Math.abs(xdiff - ydiff) <= t;
    }
}