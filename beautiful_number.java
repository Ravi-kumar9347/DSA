class Solution {
    public boolean beautifulNumber(int n) {
        //O(KlogN)
        //S(K)  k -> different numbers formed in set
        Set<Integer> set = new HashSet<>();
        while(n != 1){
            int num = n;
            int sqrNum = 0;
            while(num > 0){
                int rem = num % 10;
                rem = rem * rem;
                sqrNum += rem;
                num = num/10;
            }
            if(set.contains(sqrNum)) return false;
            set.add(sqrNum);
            n = sqrNum;
        }
        return true;
    }
}