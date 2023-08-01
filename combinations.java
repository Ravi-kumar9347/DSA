class Solution {
    public List<List<Integer>> combine(int n, int k) {
        //O(2 ^ N)
        //S(2 ^ N)
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(1, n, k, result, list);
        return result;
    }

    private void fun(int i, int n, int k, List<List<Integer>> result, List<Integer> list){
        if(list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int j = i; j <= n; j++){
            list.add(j);
            fun(j + 1, n, k, result, list);
            list.remove(list.size() - 1);
        }
    }
}