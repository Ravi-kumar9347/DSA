class Solution {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
//O(N)
//S(1)
        int count = 0;
        for(int hour : hours){
            if(hour >= target) count++;
        }
        return count;
    }
}