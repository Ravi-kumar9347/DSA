class Solution {
    public List<List<Integer>> generate(int numRows) {
        //O(N*N)
        //S(1)
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < numRows; i++){
            result.add(new ArrayList<>());
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) result.get(i).add(1);
                else result.get(i).add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
            }
        }

        return result;
    }
}