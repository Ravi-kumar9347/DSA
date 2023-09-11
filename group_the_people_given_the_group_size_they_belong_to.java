class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        //O(N)
        //S(N)
        int n = groupSizes.length;
        HashMap<Integer, List<Integer>> element = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < n; i++){
            int size = groupSizes[i];
            element.putIfAbsent(size, new ArrayList<>());
            element.get(size).add(i);

            if(element.get(size).size() == size){
                result.add(new ArrayList<>(element.get(size)));
                element.get(size).clear();
            } 
        }
        return result;
    }
}