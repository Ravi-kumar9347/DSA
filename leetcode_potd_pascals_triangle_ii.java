class Solution {
    public List<Integer> getRow(int rowIndex) {
        //O(N*N)
        //S(N)
        ArrayList<Integer> prev = new ArrayList<>();
        prev.add(1);
        if(rowIndex == 0) return prev;
        prev.add(1);
        for(int i = 2; i <= rowIndex; i++){
            ArrayList<Integer> cur = new ArrayList<>();
            for(int j = 0; j <= i; j++){
                if(j == 0 || j == i) cur.add(1);
                else cur.add(prev.get(j - 1) + prev.get(j));
            }
            prev = cur;
        }
        return prev;
    }
}