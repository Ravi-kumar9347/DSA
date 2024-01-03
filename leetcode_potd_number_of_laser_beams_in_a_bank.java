class Solution {
    public int numberOfBeams(String[] bank) {
        //O(M*n)
        //S(1)
        int m = bank.length, n = bank[0].length();
        int total = 0, prev = 0;
        for(int i = 0; i < m; i++){
            int cur = 0;
            for(int j = 0; j < n; j++){
                if(bank[i].charAt(j) == '1') cur++;
            }

            if(cur == 0) continue;
            total += (prev * cur);
            prev = cur;
        }

        return total;
    }
}