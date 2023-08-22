class Solution {
    public int minimumSum(int n, int k) {
        //O(N)
        //S(N)
        Set<Integer> set = new HashSet<>();
        int sum = 0;
        int i = 1;
        while(n > 0){
            if(!set.contains(k - i)){
                sum += i;
                set.add(i);
                n--;
            }
            i++;
        }
        return sum;
    }
}