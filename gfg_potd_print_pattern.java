class Solution{
    public List<Integer> pattern(int N){
        //O(N)
        //S(N) recursion stack space
        List<Integer> result = new ArrayList<>();
        fun(N, 0, result);
        return result;
    }
    
    private static void fun(int num, int ind, List<Integer> result){
        if(num > 0){
            result.add(ind, num);
            result.add(ind+1, num);
            fun(num-5, ind+1, result);
        }
        else{
            result.add(ind, num);
        }
    }
}