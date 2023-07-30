class Solution 
{ 
    boolean checkSorted(int N, int A[]) 
    { 
        //O(N)
        //S(N)
        if(N == 1) return false;
        int[] vis = new int[N];
        int swaps = 0;
        for(int i = 0; i < N; i++){
            int num = A[i];
            if(num == i + 1 || vis[num - 1] == 1) continue;
            Set<Integer> set = new HashSet<>();
            while(!set.contains(num) && set.size() <= 3){
                vis[num - 1] = 1;
                set.add(num);
                num = A[num - 1];
            }
            if(set.size() > 3) return false;
            if(set.size() == 2) swaps++;
            if(set.size() == 3) swaps += 2;
            if(swaps > 2) return false;
        }
        if(swaps == 0 || swaps == 2) return true;
        return false;
    }
} 