class Solution{
    public long nearestSquare(long n){
        //O(logN)
        //S(1)
        double val = Math.sqrt(n);
        long near = (long)Math.floor(val), far = (long)Math.ceil(val);
        long v1 = near * near, v2 = far * far;
        if(Math.abs(n - v1) < Math.abs(v2 - n)) return v1;
        return v2;
    }
}